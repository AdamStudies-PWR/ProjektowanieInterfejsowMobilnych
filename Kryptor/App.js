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

const KwiKryptorApp = ({}) =>
{
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen
          name="Kryptor" 
          component={KryptorActivity}
          options={({navigation}) => ({
            headerRight: () => (
              <Button
                onPress={() => navigation.navigate('Settings')}
                title="Info"
                color="#fff"
              />
          ),})}
        />
        <Stack.Screen 
          name="Settings" 
          component={SettingsActivity}
          options={({navigation}) => ({
            headerRight: () => (
              <Button
                onPress={() => navigation.navigate('About')}
                title="Info"
                color="#fff"
              />
          ),})}
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
