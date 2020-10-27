import 'react-native-gesture-handler';
import React from 'react';

import {
  Text,
  View
} from 'react-native';
import { ScrollView } from 'react-native-gesture-handler';

import styles from '../Styles/Styles.js'

const SettingsActivity = ({ navigation }) => {
  return (
    <View style = { styles.container }>
      <ScrollView>    
        <Text>Here should be settings</Text>
      </ScrollView>
    </View>);

};

export default SettingsActivity
