import 'package:flutter/rendering.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:kryptor3/config.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:flutter_phoenix/flutter_phoenix.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:share/share.dart';
import 'package:toast/toast.dart';

import 'settings.dart';

import 'dart:developer' as developer;

class KryptoScreen extends StatefulWidget {
  KryptoScreen({Key key, this.title}) : super(key: key);

  final String title;

  @override
  KryptoScreenState createState() => KryptoScreenState();
}

class KryptoScreenState extends State<KryptoScreen> {
  static const platform = const MethodChannel('com.amazeum.kryptor3/native');
  bool modeSwitch = false;
  bool copySetting = false;
  bool shareSetting = false;
  bool deleteSetting = false;
  bool darkTheme = false;
  bool startup = true;

  String mode;
  String message = "";
  String info = "unknown";

  int language = 0;

  final textController = TextEditingController();

  @override
  void dispose() {
    textController.dispose();
    super.dispose();
  }

  loadPrefferences() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();

    setState(() {
      copySetting = (prefs.getBool('copy') ?? false);
      shareSetting = (prefs.getBool('share') ?? false);
      deleteSetting = (prefs.getBool('delete') ?? false);
      darkTheme = ((prefs.getInt('theme') ?? 0) == 0) ? false : true;
      language = ((prefs.getString('lang') ?? "English") == "English") ? 0 : 1;
    });

    updateTheme();

    if (startup)
      setState(() {
        modeSwitch = ((prefs.getInt('default') ?? 0) == 0) ? false : true;
      });
  }

  void updateTheme() {
    if (darkTheme != utils.currentTheme()) {
      if (language != utils.currentLanguage()) utils.switchLanguage();
      utils.switchTheme();
      Phoenix.rebirth(context);
    } else {
      if (language != utils.currentLanguage()) {
        utils.switchLanguage();
        Phoenix.rebirth(context);
      }
    }
  }

  openSetting() async {
    await Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => SettingsScreen()),
    );

    loadPrefferences();
  }

  encrypt(String input) async {
    String encrypted;
    try {
      final String output =
          await platform.invokeMethod('encryptText', {'message': input});
      encrypted = output;
    } on PlatformException catch (error) {
      encrypted = "Kotlin error";
    }

    setState(() {
      message = encrypted;
    });

    if (copySetting) copyMessage();
    if (shareSetting) shareMessage();
  }

  decrypt(String input) async {
    String decrypted;
    try {
      final String output =
          await platform.invokeMethod('decryptText', {'message': input});
      decrypted = output;
    } on PlatformException catch (error) {
      decrypted = "Kotlin error";
    }

    setState(() {
      message = decrypted;
    });

    if (copySetting) copyMessage();
    if (shareSetting) shareMessage();
  }

  void handleMessage() {
    String message = textController.text;

    modeSwitch ? decrypt(message) : encrypt(message);

    if (deleteSetting) textController.clear();
  }

  void changeMode(bool value) {
    setState(() {
      (modeSwitch = value)
          ? mode = AppLocalizations.of(context).decryption
          : mode = AppLocalizations.of(context).encryption;
    });
  }

  void copyMessage() {
    if (message.isNotEmpty) {
      ClipboardData data = ClipboardData(text: message);
      Clipboard.setData(data);

      Toast.show(info, context,
          duration: Toast.LENGTH_SHORT, gravity: Toast.BOTTOM);
    }
  }

  void shareMessage() {
    final RenderBox box = context.findRenderObject();
    if (message.isNotEmpty) {
      Share.share(message,
          sharePositionOrigin: box.localToGlobal(Offset.zero) & box.size);
    }
  }

  @override
  Widget build(BuildContext context) {
    //AppLocalizations.load(Locale('en', ''));
    if (startup) {
      info = AppLocalizations.of(context).copied;
      loadPrefferences();
      startup = !startup;
    }
    modeSwitch
        ? mode = AppLocalizations.of(context).decryption
        : mode = AppLocalizations.of(context).encryption;
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
        appBar: AppBar(
          // Here we take the value from the MyHomePage object that was created by
          // the App.build method, and use it to set our appbar title.
          title: Center(
            child: Padding(
                padding: EdgeInsets.only(left: 40.0),
                child: Text(widget.title)),
          ),
          actions: <Widget>[
            Padding(
                padding: EdgeInsets.only(right: 10.0),
                child: GestureDetector(
                    onTap: openSetting, child: Icon(Icons.settings))),
          ],
        ),
        body: Column(crossAxisAlignment: CrossAxisAlignment.stretch, children: [
          Expanded(
              child: ListView(scrollDirection: Axis.vertical, children: [
            Column(
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Container(
                        padding: EdgeInsets.fromLTRB(20, 20, 0, 0),
                        child: Text(mode)),
                    Container(
                        padding: EdgeInsets.fromLTRB(0, 20, 10, 0),
                        child: Switch(
                            value: modeSwitch,
                            activeColor: Theme.of(context).dividerColor,
                            onChanged: (value) => changeMode(value)))
                  ],
                ),
                Container(
                    height: 320,
                    width: MediaQuery.of(context).size.width - 40,
                    padding: EdgeInsets.fromLTRB(10, 5, 10, 5),
                    color: Theme.of(context).dividerColor,
                    child: SingleChildScrollView(
                        scrollDirection: Axis.vertical, child: Text(message))),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Container(
                        padding: EdgeInsets.fromLTRB(30, 20, 0, 0),
                        child: RaisedButton.icon(
                            onPressed: shareMessage,
                            icon: Icon(Icons.share),
                            label: Text(AppLocalizations.of(context).share))),
                    Container(
                        padding: EdgeInsets.fromLTRB(0, 20, 30, 0),
                        child: RaisedButton.icon(
                            icon: Icon(Icons.copy),
                            onPressed: () => copyMessage(),
                            label: Text(AppLocalizations.of(context).copy)))
                  ],
                ),
              ],
            )
          ])),
          Container(
              child: Row(
            children: <Widget>[
              Flexible(
                child: TextField(
                  controller: textController,
                  decoration: InputDecoration(
                      hintText: AppLocalizations.of(context).hint),
                ),
              ),
              IconButton(
                icon: Icon(Icons.send, color: Theme.of(context).buttonColor),
                onPressed: handleMessage,
              )
            ],
          ))
        ]) // This trailing comma makes auto-formatting nicer for build methods.
        );
  }
}
