/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import 'react-native-gesture-handler';
import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack'

import KryptorActivity from './Activities/Kryptor.js'
import SettingsActivity from './Activities/Settings.js'
import AboutActivity from './Activities/About.js'

import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Button,
  Text,
  StatusBar,
} from 'react-native';

import {
  Header,
  LearnMoreLinks,
  Colors,
  DebugInstructions,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';

const Stack = createStackNavigator();

const KwiKryptorApp: () => React$Node = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen
          name="Kryptor"
          component={KryptorActivity}
        />
        <Stack.Screen 
          name="Settings" 
          component={SettingsActivity}
        />
        <Stack.Screen 
          name="About" 
          component={AboutActivity}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
};



export default KwiKryptorApp;
