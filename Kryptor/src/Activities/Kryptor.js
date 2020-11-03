import 'react-native-gesture-handler';
import React from 'react';
import { Component } from 'react';

import {
  TouchableHighlight,
  View,
  StatusBar,
  Text,
  Button
} from 'react-native';
import { ScrollView, TextInput } from 'react-native-gesture-handler';
import Icon from 'react-native-vector-icons/Feather';

import styles from '../Styles/Styles.js'
import MySwitch from '../Components/mySwitch.js'
import Converter from '../modules/Converter.js';

class KryptorActivity extends Component 
{
  constructor()
  {
    super()
    this.state = {
      decryption: false,
      output: "",
      input: ""
    }
  }

  toggleMode = (value) => {
    this.setState({decryption: value})
  }

  sendButton(){this.kryptoFunction()}

  kryptoFunction = async() => {
    var result = ""
    if(this.state.decryption)
    {
      try
      {
        result = await Converter.decryption(this.state.input)
      }
      catch(error)
      {
        console.error(error)
      }
    }
    else
    {
      try
      {
        result = await Converter.encryption(this.state.input)
      }
      catch(error)
      {
        console.error(error)
      }
    }
    console.log("Triggered");
    this.setState(
      {
        output: result,
        input: ""
      }
    )
  }

  render()
  {
    return (
    <View style = {styles.container}>
      <ScrollView>
        <StatusBar backgroundColor='#00334C'/>
        <View style={styles.rowView}>
          <Text style={styles.switch}>{this.state.decryption ? 'Decryption' : 'Encryption'}</Text>
          <MySwitch
            toggleSwitch={this.toggleMode}
            switchValue={this.state.decryption}
          />
        </View>
        <View>
          <Text>{this.state.output}</Text>
        </View>
        <View style={styles.rowView}>
          <Icon.Button
            style={styles.button}
             name="copy">
             Copy
          </Icon.Button>
          <Icon.Button
            style={styles.button}
            name="share">
            Share
          </Icon.Button>
        </View>
        <View style={styles.messageBox}>
          <View style={styles.rowView}>
            <TextInput
              onChangeText={text => this.state.input=text}
            />
            <Icon.Button
              style={styles.send}
              name="send"
              onPress={this.sendButton()}
            />
          </View>
        </View>
      </ScrollView>
    </View>);
  }
  
}

export default KryptorActivity
