import 'react-native-gesture-handler';
import React from 'react';

import {
  View,
  StatusBar,
  Text
} from 'react-native';
import { ScrollView } from 'react-native-gesture-handler';

import styles from '../Styles/Styles.js'

const KryptorActivity = ({ navigation }) => {
  return (
    <View style = { styles.container }>
      <ScrollView>
        <StatusBar backgroundColor='#00334C'/>
        <Text>This is main activity</Text>
      </ScrollView>
    </View>);
  };

export default KryptorActivity
