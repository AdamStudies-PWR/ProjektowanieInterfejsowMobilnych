import 'package:flutter/rendering.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:flutter/material.dart';
import 'settings.dart';

import 'dart:developer' as developer;

class KryptoScreen extends StatefulWidget {
  KryptoScreen({Key key, this.title}) : super(key: key);

  final String title;

  @override
  KryptoScreenState createState() => KryptoScreenState();
}

class KryptoScreenState extends State<KryptoScreen> {
  bool modeSwitch = false;

  String mode;

  void openSetting() {
    Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => SettingsScreen()),
    );
  }

  void changeMode(bool value) {
    setState(() {
      (modeSwitch = value)
          ? mode = AppLocalizations.of(context).decryption
          : mode = AppLocalizations.of(context).encryption;
    });

    developer.log("Changed: " + mode, name: "info");
  }

  @override
  Widget build(BuildContext context) {
    mode = AppLocalizations.of(context).encryption;
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
        body: Column(children: [
          ListView(
            scrollDirection: Axis.vertical,
            shrinkWrap: true,
            children: [
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
                ],
              )
            ],
          ),
          /*Row(
            children: [
              TextField(
                  decoration: InputDecoration(
                      border: InputBorder.none, hintText: "Kwi")),
              RaisedButton(onPressed: null, child: Text("Send"))
            ],
          )*/
        ]) // This trailing comma makes auto-formatting nicer for build methods.
        );
  }
}
