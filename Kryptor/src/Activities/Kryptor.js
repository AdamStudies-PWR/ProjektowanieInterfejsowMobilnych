import 'react-native-gesture-handler';
import React, { useState } from 'react';

import {
  Switch,
  View,
  StatusBar,
  Text
} from 'react-native';
import { ScrollView } from 'react-native-gesture-handler';

import styles from '../Styles/Styles.js'

const KryptorActivity = ({}) => {
  // Elements
  [decryption, setIsEnabled] = useState(false);

  // Functions
  toggleMode = () => {
    setIsEnabled(previousState => !previousState)
  }

  // Render
  return (
    <View style = { styles.container }>
      <ScrollView>
        <StatusBar backgroundColor='#00334C'/>
        <View style={styles.rowView}>
          <Text style={styles.switch}>{decryption ? 'Decryption' : 'Encryption'}</Text>
          <Switch
            style={styles.switch}
            onValueChange={toggleMode}
            value={decryption}
            label="Encryption"
          />
        </View>
      </ScrollView>
    </View>);
  };

export default KryptorActivity
