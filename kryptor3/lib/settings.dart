import 'package:flutter/cupertino.dart';
import 'package:flutter/rendering.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:flutter/material.dart';

import 'about.dart';

import 'dart:developer' as developer;

class SettingsScreen extends StatefulWidget {
  SettingsScreen({Key key}) : super(key: key);

  @override
  SettingsScreenState createState() => SettingsScreenState();
}

class SettingsScreenState extends State<SettingsScreen> {
  bool copySwitch = false;
  bool shareSwitch = false;
  bool deleteSwitch = false;
  bool startup = true;

  String languageBox = "English";

  var defaultBox = <String>[];
  var themeBox = <String>[];

  int defaultChoice = 0;
  int themeChoice = 0;

  loadPrefferences() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();

    setState(() {
      languageBox = (prefs.getString('lang') ?? 'English');
      defaultChoice = (prefs.getInt('default') ?? 0);
      themeChoice = (prefs.getInt('theme') ?? 0);
      copySwitch = (prefs.getBool('copy') ?? false);
      shareSwitch = (prefs.getBool('share') ?? false);
      deleteSwitch = (prefs.getBool('delete') ?? false);
    });
  }

  void openAbout() {
    Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => AboutScreen()),
    );
  }

  saveSwitchSettings(String key) async {
    SharedPreferences prefs = await SharedPreferences.getInstance();

    switch (key) {
      case 'copy':
        prefs.setBool(key, copySwitch);
        break;
      case 'share':
        prefs.setBool(key, shareSwitch);
        break;
      case 'delete':
        prefs.setBool(key, deleteSwitch);
        break;
    }
  }

  saveSettings() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();

    prefs.setString('lang', languageBox);
    prefs.setInt("default", defaultChoice);
    prefs.setInt("theme", themeChoice);

    Navigator.of(context).pop();
  }

  @override
  Widget build(BuildContext context) {
    if (startup) {
      defaultBox.add(AppLocalizations.of(context).encryption);
      defaultBox.add(AppLocalizations.of(context).decryption);
      themeBox.add(AppLocalizations.of(context).light);
      themeBox.add(AppLocalizations.of(context).dark);
      loadPrefferences();
      startup = !startup;
    }

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
          child: Text(AppLocalizations.of(context).settings),
        ),
        actions: <Widget>[
          Padding(
              padding: EdgeInsets.only(right: 10.0),
              child: GestureDetector(
                  onTap: openAbout, child: Icon(Icons.info_outline))),
        ],
      ),
      body: ListView(scrollDirection: Axis.vertical, children: [
        Column(
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Container(
                    padding: EdgeInsets.fromLTRB(20, 20, 0, 0),
                    child: Text(AppLocalizations.of(context).copySwitch)),
                Container(
                    padding: EdgeInsets.fromLTRB(0, 20, 10, 0),
                    child: Switch(
                      value: copySwitch,
                      onChanged: (value) {
                        setState(() {
                          copySwitch = value;
                        });
                        saveSwitchSettings("copy");
                      },
                    ))
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Container(
                    padding: EdgeInsets.fromLTRB(20, 0, 0, 0),
                    child: Text(AppLocalizations.of(context).shareSwitch)),
                Container(
                    padding: EdgeInsets.fromLTRB(0, 0, 10, 0),
                    child: Switch(
                      value: shareSwitch,
                      onChanged: (value) {
                        setState(() {
                          shareSwitch = value;
                        });
                        saveSwitchSettings("share");
                      },
                    ))
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Container(
                    padding: EdgeInsets.fromLTRB(20, 0, 0, 0),
                    child: Text(AppLocalizations.of(context).deleteSwitch)),
                Container(
                    padding: EdgeInsets.fromLTRB(0, 0, 10, 0),
                    child: Switch(
                      value: deleteSwitch,
                      onChanged: (value) {
                        setState(() {
                          deleteSwitch = value;
                        });
                        saveSwitchSettings("delete");
                      },
                    ))
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Container(
                    padding: EdgeInsets.fromLTRB(20, 40, 0, 0),
                    child: Text(AppLocalizations.of(context).defaultMode)),
                Container(
                    padding: EdgeInsets.fromLTRB(0, 40, 30, 0),
                    child: DropdownButton<String>(
                      value: defaultChoice == null
                          ? null
                          : defaultBox[defaultChoice],
                      icon: Icon(Icons.arrow_downward),
                      onChanged: (String newValue) {
                        setState(() {
                          defaultChoice = defaultBox.indexOf(newValue);
                        });
                      },
                      items: defaultBox
                          .map<DropdownMenuItem<String>>((String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                    ))
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Container(
                    padding: EdgeInsets.fromLTRB(20, 0, 0, 0),
                    child: Text(AppLocalizations.of(context).language)),
                Container(
                    padding: EdgeInsets.fromLTRB(0, 0, 30, 0),
                    child: DropdownButton<String>(
                      value: languageBox,
                      icon: Icon(Icons.arrow_downward),
                      onChanged: (String newValue) {
                        setState(() {
                          languageBox = newValue;
                        });
                      },
                      items: <String>["English", "Polski"]
                          .map<DropdownMenuItem<String>>((String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                    ))
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Container(
                    padding: EdgeInsets.fromLTRB(20, 0, 0, 0),
                    child: Text(AppLocalizations.of(context).theme)),
                Container(
                    padding: EdgeInsets.fromLTRB(0, 0, 30, 0),
                    child: DropdownButton<String>(
                      value: themeChoice == null ? null : themeBox[themeChoice],
                      icon: Icon(Icons.arrow_downward),
                      onChanged: (String newValue) {
                        setState(() {
                          themeChoice = themeBox.indexOf(newValue);
                        });
                      },
                      items: themeBox
                          .map<DropdownMenuItem<String>>((String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                    ))
              ],
            ),
            Container(
                padding: EdgeInsets.fromLTRB(0, 40, 0, 0),
                child: RaisedButton(
                    onPressed: saveSettings,
                    child: Text(AppLocalizations.of(context).apply)))
          ],
        )
      ]),
    );
  }
}
