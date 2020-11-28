import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:flutter/material.dart';

import 'config.dart';
import 'krypto.dart';
import 'settings.dart';
import 'about.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      localizationsDelegates: [
        AppLocalizations.delegate,
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        GlobalCupertinoLocalizations.delegate,
      ],
      supportedLocales: [
        const Locale('pl', ''),
        const Locale('en', ''),
      ],
      title: 'Kryptor',
      theme: myThemes.getTheme(),
      home: KryptoScreen(title: 'Kryptor'),
      routes: <String, WidgetBuilder> {
        'KryptoScreen': (BuildContext context) => new KryptoScreen(title: 'Kryptor'),
        'SettingsScreen' : (BuildContext context) => new SettingsScreen(),
        'AboutScreen' : (BuildContext context) => new AboutScreen()
      },
    );
  }
}
