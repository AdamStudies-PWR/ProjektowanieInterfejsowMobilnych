import 'package:flutter/material.dart';

import 'dart:developer' as developer;

class Themes with ChangeNotifier {
  static bool isDark = true;

  final purple = ThemeData(
    primaryColor: Colors.purple,
    brightness: Brightness.dark,
    backgroundColor: const Color(0xFF212121),
    accentColor: Colors.purple,
    buttonColor: Colors.purple,
    accentIconTheme: IconThemeData(color: Colors.black),
    dividerColor: Colors.purple
  );

  final lightGreen = ThemeData(
    primaryColor: Colors.green,
    brightness: Brightness.light,
    backgroundColor: const Color(0xFFE5E5E5),
    accentColor: Colors.green,
    buttonColor: Colors.green,
    accentIconTheme: IconThemeData(color: Colors.white),
    dividerColor: Colors.green
  );

  ThemeData getTheme() {
    return isDark ? purple : lightGreen;
  }

  void switchTheme() {
    isDark = !isDark;
    notifyListeners();
  }
}
