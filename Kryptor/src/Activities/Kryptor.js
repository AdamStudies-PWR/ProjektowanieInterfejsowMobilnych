import 'react-native-gesture-handler';
import React from 'react';
import { Component } from 'react';

import {
  Share,
  View,
  StatusBar,
  Text,
  ToastAndroid,
} from 'react-native';
import Clipboard from '@react-native-community/clipboard';
import { ScrollView, TextInput } from 'react-native-gesture-handler';
import Icon from 'react-native-vector-icons/Feather';
import { NavigationContainer } from '@react-navigation/native';
import AsyncStorage from '@react-native-community/async-storage';

import styles from '../Styles/Styles.js'
import MySwitch from '../Components/mySwitch.js'
import Converter from '../modules/Converter.js';

class KryptorActivity extends Component 
{
  constructor(props)
  {
    super(props)
    this.props = props
    this.state = {
      decryption: false,
      output: "",
      input: "",
      auto_copy: false,
      auto_share: false,
      auto_delete: false
    }
    this.loadCopySettings()
    this.loadShareSettings()
    this.loadDeleteSettings()
    this.loadDefaultSettings()
  }

  unsubscribe = this.props.navigation.addListener('focus', () => {
    this.loadCopySettings()
    this.loadShareSettings()
    this.loadDeleteSettings()
  })

  toggleMode = (value) => {
    this.setState({decryption: value})
  }

  loadDefaultSettings = async() => {
    var result
    try
    {
      result = await AsyncStorage.getItem("defaultMode")
      if (result !== null)
      {
        if (result !== "0") result = true
        else result = false
      }
      else result = false
    }
    catch (error)
    {
      alert(error.message)
    }
    console.log("Read: " + result)
    this.setState({ decryption: result })
  }

  loadDeleteSettings = async() => {
    var result
    try
    {
      result = await AsyncStorage.getItem("deleteSettings")
      if (result !== null)
      {
        if (result !== "1") result = false
        else result = true
      }
      else result = false
    }
    catch (error)
    {
      alert(error.message)
    }
    this.setState({ auto_delete: result })
  }

  loadCopySettings = async() => {
    var result
    try
    {
      result = await AsyncStorage.getItem("copySettings")
      if (result !== null)
      {
        if (result !== "1") result = false
        else result = true
      }
      else result = false
    }
    catch (error)
    {
      alert(error.message)
    }
    this.setState({ auto_copy: result })
  }

  loadShareSettings = async() => {
    var result
    try
    {
      result = await AsyncStorage.getItem("shareSettings")
      if (result !== null)
      {
        if (result !== "1") result = false
        else result = true
      }
      else result = false
    }
    catch (error)
    {
      alert(error.message)
    }
    this.setState({ auto_share: result })
  }


  sendButton(){ this.kryptoFunction() }

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
    if (this.state.auto_delete) 
    {
      this.textInput.clear()
      this.setState(
        {
          output: result,
          input: ""
        }
      )
    }
    else this.setState({ output: result })
    if (this.state.auto_copy) this.copyButton();
    if (this.state.auto_share) this.shareButton();
  }

  copyButton()
  {
    Clipboard.setString(this.state.output)
    ToastAndroid.show("Copied !", ToastAndroid.SHORT)
  }

  shareButton() { this.shareFunction() }

  shareFunction = async() => {
    try
    {
      const result = await Share.share(
      {
        message: this.state.output,
      })
      if (result.action === Share.sharedAction)
      {
        if (result.activityType) {} 
        else {}
      } else if (result.action === Share.dismissedAction) {}
    }
    catch (error)
    {
      alert(error.message)
    }
  }

  render()
  {
    return (
    <View style = {styles.container}>
      <ScrollView style={styles.scrollStyle}>
        <StatusBar backgroundColor='#00334C'/>
        <View style={styles.rowView}>
          <Text style={styles.switch}>{this.state.decryption ? 'Decryption' : 'Encryption'}</Text>
          <MySwitch
            toggleSwitch={this.toggleMode}
            switchValue={this.state.decryption}
          />
        </View>
        <ScrollView style={styles.textOutput}>
          <Text>{this.state.output}</Text>
        </ScrollView>
        <View style={styles.rowView}>
          <Icon.Button
            style={styles.button}
            name="copy"
            onPress={() => this.copyButton()}>
             Copy
          </Icon.Button>
          <Icon.Button
            style={styles.button}
            name="share"
            onPress={() => this.shareButton()}>
            Share
          </Icon.Button>
        </View>
      </ScrollView>
      <View style={styles.messageBox}>
          <View style={styles.rowView}>
            <TextInput
              style={styles.textInput}
              ref={input => {this.textInput = input}}
              onChangeText={text => this.state.input=text}
              placeholder="Enter Message"
            />
            <Icon.Button
              style={styles.send}
              name="send"
              onPress={() => this.sendButton()}
            />
          </View>
        </View>
    </View>);
  }
  
}

export default KryptorActivity
