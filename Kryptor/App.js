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
import Icon from 'react-native-vector-icons/Feather';

import KryptorActivity from './src/Activities/Kryptor.js'
import SettingsActivity from './src/Activities/Settings.js'
import AboutActivity from './src/Activities/About.js'

const Stack = createStackNavigator();

const KwiKryptorApp = ({}) =>
{
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen
          name="KwiKryptor"
          //component={KryptorActivity}
          options={({navigation}) => ({
            headerTitleStyle: { alignSelf: 'center', textAlign: 'center', marginLeft: 60},
            headerStyle: {
              backgroundColor: '#00334C',
            },
            headerRight: () => (
              <Icon.Button
                name="settings"
                backgroundColor="#00334C"
                onPress={() => navigation.navigate('Settings')}
              />
          ),})}>
            {props => <KryptorActivity {...props} extraData={false} />}
        </Stack.Screen>            
        <Stack.Screen 
          name="Settings" 
          component={SettingsActivity}
          options={({navigation}) => ({
            headerTitleStyle: { alignSelf: 'center' },
            headerStyle: {
              backgroundColor: '#00334C',
            },
            headerRight: () => (
              <Icon.Button
                name="help-circle"
                backgroundColor="#00334C"
                onPress={() => navigation.navigate('About')}
              />            
          ),})}
        />
        <Stack.Screen 
          name="About" 
          component={AboutActivity}
          options={({}) => ({
            headerTitleStyle: { alignSelf: 'center', textAlign: 'center', marginRight: 55 },
            headerStyle: {
              backgroundColor: '#00334C',
          },})}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default KwiKryptorApp;
