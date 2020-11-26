import 'package:flutter/cupertino.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:flutter/material.dart';
import 'about.dart';

class SettingsScreen extends StatefulWidget {
  SettingsScreen({Key key}) : super(key: key);

  @override
  SettingsScreenState createState() => SettingsScreenState();
}

class SettingsScreenState extends State<SettingsScreen> {
  bool copySwitch = false;
  bool shareSwitch = false;
  bool deleteSwitch = false;

  String defaultBox;
  String languageBox;
  String themeBox;

  void openAbout() {
    Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => AboutScreen()),
    );
  }

  @override
  Widget build(BuildContext context) {
    defaultBox = AppLocalizations.of(context).encryption;
    languageBox = "English";
    themeBox = AppLocalizations.of(context).light;

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
                      value: defaultBox,
                      icon: Icon(Icons.arrow_downward),
                      onChanged: (String newValue) {
                        setState(() {
                          defaultBox = newValue;
                        });
                      },
                      items: <String>[
                        AppLocalizations.of(context).encryption,
                        AppLocalizations.of(context).decryption
                      ].map<DropdownMenuItem<String>>((String value) {
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
                      value: themeBox,
                      icon: Icon(Icons.arrow_downward),
                      onChanged: (String newValue) {
                        setState(() {
                          themeBox = newValue;
                        });
                      },
                      items: <String>[
                        AppLocalizations.of(context).light,
                        AppLocalizations.of(context).dark
                      ].map<DropdownMenuItem<String>>((String value) {
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
                    onPressed: null,
                    child: Text(AppLocalizations.of(context).apply)))
          ],
        )
      ]),
    );
  }
}

/*
Column(
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Container(
                    padding: EdgeInsets.fromLTRB(20, 20, 0, 0),
                    child: Text(AppLocalizations.of(context).copySwitch)),
                Container(
                    padding: EdgeInsets.fromLTRB(0, 20, 20, 0),
                    alignment: Alignment(-1, 1),
                    child: Switch(
                      value: copySwitch,
                      onChanged: (value) {
                        setState(() {
                          copySwitch = value;
                        });
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
                    padding: EdgeInsets.fromLTRB(0, 0, 20, 0),
                    alignment: Alignment(-1, 1),
                    child: Switch(
                      value: shareSwitch,
                      onChanged: (value) {
                        setState(() {
                          shareSwitch = value;
                        });
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
                    padding: EdgeInsets.fromLTRB(0, 0, 20, 0),
                    alignment: Alignment(-1, 1),
                    child: Switch(
                      value: copySwitch,
                      onChanged: (value) {
                        setState(() {
                          shareSwitch = value;
                        });
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
                    padding: EdgeInsets.fromLTRB(0, 40, 40, 0),
                    child: DropdownButton<String>(
                      value: defaultBox,
                      icon: Icon(Icons.arrow_downward),
                      onChanged: (String newValue) {
                        setState(() {
                          defaultBox = newValue;
                        });
                      },
                      items: <String>[
                        AppLocalizations.of(context).encryption,
                        AppLocalizations.of(context).decryption
                      ].map<DropdownMenuItem<String>>((String value) {
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
                    padding: EdgeInsets.fromLTRB(0, 0, 40, 0),
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
                    padding: EdgeInsets.fromLTRB(0, 0, 40, 0),
                    child: DropdownButton<String>(
                      value: themeBox,
                      icon: Icon(Icons.arrow_downward),
                      onChanged: (String newValue) {
                        setState(() {
                          themeBox = newValue;
                        });
                      },
                      items: <String>[
                        AppLocalizations.of(context).light,
                        AppLocalizations.of(context).dark
                      ].map<DropdownMenuItem<String>>((String value) {
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
                onPressed: null,
                child: Text(AppLocalizations.of(context).apply)
              )
            )
          ],
        )
 */
