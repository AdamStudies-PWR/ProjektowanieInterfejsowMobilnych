import 'package:flutter/material.dart';

import 'dart:developer' as developer;

class Utility extends ChangeNotifier {
  static bool isDark = true;
  static int language = 1;

  final polish = Locale('pl', '');
  final english = Locale('en', '');

  final purple = ThemeData(
      primaryColor: Colors.purple,
      brightness: Brightness.dark,
      backgroundColor: const Color(0xFF212121),
      accentColor: Colors.purple,
      buttonColor: Colors.purple,
      accentIconTheme: IconThemeData(color: Colors.black),
      dividerColor: Colors.purple);

  final lightGreen = ThemeData(
      primaryColor: Colors.green,
      brightness: Brightness.light,
      backgroundColor: const Color(0xFFE5E5E5),
      accentColor: Colors.green,
      buttonColor: Colors.green,
      accentIconTheme: IconThemeData(color: Colors.white),
      dividerColor: Colors.green);

  ThemeData getTheme() {
    return isDark ? purple : lightGreen;
  }

  Locale getLanguage() {
    return (language == 0) ? english : polish;
  }

  int currentLanguage() {
    return language;
  }

  bool currentTheme() {
    return isDark;
  }

  void switchTheme() {
    isDark = !isDark;
    notifyListeners();
  }

  void switchLanguage() {
    language == 0 ? language = 1 : language = 0;
    notifyListeners();
  }

}
