import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:flutter/material.dart';

class AboutScreen extends StatefulWidget {
  AboutScreen({Key key}) : super(key: key);

  @override
  AboutScreenState createState() => AboutScreenState();
}

class AboutScreenState extends State<AboutScreen> {
  void openAbout() {
    Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => AboutScreen()),
    );
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
              padding: EdgeInsets.only(right: 40.0), child: Text(AppLocalizations.of(context).about)),
        ),
      ),
      body: Center(),
    );
  }
}
