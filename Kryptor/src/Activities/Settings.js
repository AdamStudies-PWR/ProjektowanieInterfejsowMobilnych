import 'react-native-gesture-handler';
import React from 'react';

import {
  Button,
  Text,
  View,
} from 'react-native';
import { ScrollView } from 'react-native-gesture-handler';
import {Picker} from '@react-native-picker/picker';

import styles from '../Styles/Styles.js';
import { Component } from 'react';
import MySwitch from '../Components/mySwitch.js';

class SettingsActivity extends Component
{
  constructor()
  {
    super()
    this.state = {
      mode: 'Encryption',
      language: 'English',
      theme: 'Deep Blue'
    }
  }

  handleMode(index, chosen)
  {
    this.setState({ mode: chosen })
    console.log("Chosen: " + index)
  }

  handleLanguage(index, chosen)
  {
    this.setState({ language: chosen })
    console.log("Chosen: " + index)
  }

  handleTheme(index, chosen)
  {
    this.setState({ theme: chosen })
    console.log("Chosen: " + index)
  }

  render()
  {
    return (
    <View style = { styles.container }>
      <ScrollView>    
        <View style={styles.rowView}>
          <Text style={styles.switch}>Auto copy</Text>
          <MySwitch
            // Do uzupełnienia!
          />
        </View>
        <View style={styles.rowView}>
          <Text style={styles.switch}>Auto share</Text>
          <MySwitch
            // Do uzupełnienia!
          />
        </View>
        <View style={styles.rowView}>
          <Text style={styles.switch}>Delete text</Text>
          <MySwitch
            // Do uzupełnienia!
          />
        </View>
        <View style={styles.rowView}>
          <Text style={styles.picker}>Default mode</Text>
          <Picker 
          selectedValue={this.state.mode}
          style={styles.comboBox}
          mode='dropdown'
          onValueChange={(itemValue, itemIndex) => this.handleMode(itemIndex, itemValue)}>
            <Picker.Item label="Encryption" value="encryption"/>
            <Picker.Item label="Decryption" value="decryption"/>
          </Picker>
        </View>
        <View style={styles.rowView}>
          <Text style={styles.picker}>Default mode</Text>
          <Picker
          name="Language"
          selectedValue={this.state.language}
          style={styles.comboBox}
          mode='dropdown'
          onValueChange={(itemValue, itemIndex) => this.handleLanguage(itemIndex, itemValue)}>
            <Picker.Item label="English" value="english"/>
            <Picker.Item label="Polish" value="polish"/>
          </Picker>
        </View>
        <View style={styles.rowView}>
          <Text style={styles.picker}>Default mode</Text>
          <Picker 
          selectedValue={this.state.theme}
          style={styles.comboBox}
          mode='dropdown'
          onValueChange={(itemValue, itemIndex) => this.handleTheme (itemIndex, itemValue)}>
            <Picker.Item label="Deep blue" value="deep_blue"/>
            <Picker.Item label="Bannana white" value="Bannana white"/>
          </Picker>
        </View>
        <Button
          style={styles.button2}
          title="Apply"
        />
      </ScrollView>
    </View>);
  }

};

export default SettingsActivity
