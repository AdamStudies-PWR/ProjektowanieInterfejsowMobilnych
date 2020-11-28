import 'package:flutter/material.dart';

class Themes with ChangeNotifier {
  static bool isDark = false;

  final purple = ThemeData(
    primarySwatch: Colors.green,
    primaryColor: Colors.black,
    brightness: Brightness.dark,
    backgroundColor: const Color(0xFF212121),
    accentColor: Colors.white,
    accentIconTheme: IconThemeData(color: Colors.black),
    dividerColor: Colors.black12,
  );

  final lightGreen = ThemeData(
    primarySwatch: Colors.grey,
    primaryColor: Colors.white,
    brightness: Brightness.light,
    backgroundColor: const Color(0xFFE5E5E5),
    accentColor: Colors.black,
    accentIconTheme: IconThemeData(color: Colors.white),
    dividerColor: Colors.white54,
  );

  ThemeData getTheme() {
    return isDark ? purple : lightGreen;
  }

  void switchTheme() {
    isDark = !isDark;
  }
}
