import 'package:flutter/rendering.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
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

  String mode;
  String message = "";
  String info = "unknown";

  final textController = TextEditingController();

  @override
  void dispose() {
    textController.dispose();
    super.dispose();
  }


  void openSetting() {
    Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => SettingsScreen()),
    );
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
  }

  void handleMessage() {
    String message = textController.text;

    modeSwitch ? decrypt(message) : encrypt(message);
  }

  void changeMode(bool value) {
    setState(() {
      (modeSwitch = value)
          ? mode = AppLocalizations.of(context).decryption
          : mode = AppLocalizations.of(context).encryption;
    });
  }

  void copyMessage(BuildContext context) {
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
    info = AppLocalizations.of(context).copied;
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
                            onChanged: (value) => changeMode(value)))
                  ],
                ),
                Container(
                    height: 320,
                    width: MediaQuery.of(context).size.width - 40,
                    padding: EdgeInsets.fromLTRB(10, 5, 10, 5),
                    color: Colors.grey,
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
                            onPressed: () => copyMessage(context),
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
                icon: Icon(Icons.send),
                onPressed: handleMessage,
              )
            ],
          ))
        ]) // This trailing comma makes auto-formatting nicer for build methods.
        );
  }
}
