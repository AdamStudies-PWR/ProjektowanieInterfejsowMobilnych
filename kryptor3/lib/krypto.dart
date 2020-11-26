import 'package:flutter/rendering.dart';
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
  }

  @override
  Widget build(BuildContext context) {
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
                      scrollDirection: Axis.vertical,
                      child: Text(
                          "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent hendrerit lorem sapien, id auctor ante blandit ac. Aliquam molestie, mi in pretium imperdiet, sapien justo efficitur nunc, nec interdum odio ante sed lectus. Nulla ut tempus urna, et congue ipsum. In bibendum euismod lorem, non consequat purus dignissim et. Maecenas facilisis interdum diam vel lobortis. Donec dui dolor, pharetra eu mollis a, gravida eu sem. Nunc at hendrerit mi. Donec a sem pretium, tincidunt risus tincidunt, congue diam. Cras erat enim, suscipit eu pulvinar in, elementum vel enim. Sed ullamcorper imperdiet felis vitae congue. Sed posuere mauris sed leo congue pretium. Ut nec nisl purus. Phasellus nibh nibh, ultrices sit amet purus vitae, sodales tristique sapien. Cras quis pharetra tortor. Maecenas vitae mauris et tellus semper varius. Fusce venenatis dignissim erat, sit amet accumsan augue. Nunc sollicitudin porta purus, quis condimentum tortor posuere quis. Nunc vel dui in sapien rutrum ultrices euismod in lacus. Donec commodo magna mi, sed feugiat est placerat nec. Donec sed ex arcu. Cras quis dictum ante. Nunc quis convallis risus. Vivamus molestie, lorem vel vehicula fringilla, nibh urna auctor metus, nec fringilla libero orci id sem. Suspendisse velit diam, imperdiet in accumsan sed, pellentesque quis nibh. Nam pulvinar vehicula malesuada. Nam suscipit lectus a nulla vestibulum lobortis. Etiam vehicula lobortis ultricies. Maecenas pharetra nulla felis, et dignissim velit euismod eu. Aenean neque nunc, iaculis et ornare vitae, rutrum feugiat tellus. Vestibulum sit amet tincidunt lectus, a dapibus lectus. Duis viverra quis nibh quis egestas. Sed est erat, aliquam eu egestas a, convallis sit amet nisi. Quisque vitae consectetur ex. Mauris non posuere nibh. Etiam sollicitudin iaculis velit, ac finibus augue ornare in. Morbi vehicula est ut ligula rutrum, ac tempus justo vehicula. Phasellus suscipit fermentum turpis, et volutpat diam faucibus quis. Morbi placerat finibus varius. Nullam vel pellentesque lorem. Vestibulum dignissim ex vel nunc commodo rutrum ac eu magna. Proin odio lectus, rhoncus nec vehicula placerat, gravida eu sapien. Phasellus libero urna, sagittis convallis eros eu, mattis semper est. Etiam at velit eget augue fermentum dapibus. Aenean a tristique massa. Ut facilisis commodo turpis sed facilisis. Duis laoreet leo non sollicitudin facilisis. Quisque vulputate ante leo, eget lacinia magna tincidunt dapibus. Morbi a urna dictum, vestibulum lorem in, elementum nulla. Donec ullamcorper, est vitae mattis efficitur, enim lorem iaculis justo, vel sollicitudin ex ante vel lectus. Duis fringilla sem eget mauris malesuada, eget fringilla leo luctus. Sed sit amet laoreet est. Cras non nulla massa. Nam at quam turpis. Cras volutpat ex augue, ac dapibus libero pellentesque at. In hac habitasse platea dictumst. Sed venenatis ullamcorper semper. Curabitur interdum leo et velit semper, eu sollicitudin mi viverra. Nunc quis elit dui.")),
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Container(
                        padding: EdgeInsets.fromLTRB(30, 20, 0, 0),
                        child: RaisedButton.icon(
                            onPressed: null,
                            icon: Icon(Icons.share),
                            label: Text(AppLocalizations.of(context).share))),
                    Container(
                        padding: EdgeInsets.fromLTRB(0, 20, 30, 0),
                        child: RaisedButton.icon(
                            icon: Icon(Icons.copy),
                            onPressed: null,
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
                  decoration: InputDecoration(
                      hintText: AppLocalizations.of(context).hint),
                ),
              ),
              IconButton(
                icon: Icon(Icons.send),
                onPressed: null,
              )
            ],
          ))
        ]) // This trailing comma makes auto-formatting nicer for build methods.
        );
  }
}
