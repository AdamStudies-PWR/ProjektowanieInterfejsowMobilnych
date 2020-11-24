import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:package_info/package_info.dart';
import 'package:flutter/material.dart';

class AboutScreen extends StatefulWidget {
  AboutScreen({Key key}) : super(key: key);

  @override
  AboutScreenState createState() => AboutScreenState();
}

class AboutScreenState extends State<AboutScreen> {
  String version = "unknown";

  @override
  void initState() {
    super.initState();
    initAsync();
  }

  initAsync() async {
    PackageInfo packageInfo = await PackageInfo.fromPlatform();

    setState(() {
      version = packageInfo.version;
    });
  }

  @override
  Widget build(BuildContext context) {
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
                padding: EdgeInsets.only(right: 40.0),
                child: Text(AppLocalizations.of(context).about)),
          ),
        ),
        body: ListView(
          scrollDirection: Axis.vertical,
          children: [
            Row(children: [
              Container(
                  padding: EdgeInsets.fromLTRB(20, 20, 0, 0),
                  child: Text(AppLocalizations.of(context).author)),
              Container(
                  padding: EdgeInsets.fromLTRB(174, 20, 0, 0),
                  child: Text("Adam Krizar")),
            ]),
            Row(children: [
              Container(
                  padding: EdgeInsets.fromLTRB(20, 20, 0, 0),
                  child: Text(AppLocalizations.of(context).engine)),
              Container(
                  padding: EdgeInsets.fromLTRB(100, 20, 0, 0),
                  child: Text("TBA")),
            ]),
            Row(children: [
              Container(
                  padding: EdgeInsets.fromLTRB(20, 20, 0, 0),
                  child: Text(AppLocalizations.of(context).app)),
              Container(
                  padding: EdgeInsets.fromLTRB(148, 20, 0, 0),
                  child: Text(version)),
            ])
          ],
        ));
  }
}
