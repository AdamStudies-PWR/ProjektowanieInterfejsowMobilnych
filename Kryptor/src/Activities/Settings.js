import 'react-native-gesture-handler';
import React from 'react';

import {  
  Button,
  Text,
  View,
} from 'react-native';
import { ScrollView } from 'react-native-gesture-handler';
import { Picker } from '@react-native-picker/picker';
import AsyncStorage from '@react-native-community/async-storage';
import { useTheme } from "react-native-themed-styles"
import { Component } from 'react';
import MySwitch from '../Components/mySwitch.js';

import strings from '../translations/translations'
import design from '../Styles/Styles.js';

const [styles] = useTheme(design)

class SettingsActivity extends Component
{
  constructor(props)
  {
    super(props)
    props.navigation.setOptions({title: strings.sett})

    this.state = {
      mode: 'encryption',
      language: 'english',
      theme: 'deep_blue',
      auto_copy: false,
      auto_share: false,
      auto_delete: false, 
      default_Index: 0,
      language_Index: 0,
      theme_Index: 0
    }

    this.loadCopySettings()
    this.loadShareSettings()
    this.loadDeleteSettings()
    this.loadDefaultSettings()
    this.loadLanguageSettings()
    this.loadThemeSettings()
  }

  handleMode(index, chosen)
  {
    this.setState(
    {
      mode: chosen,
      default_Index: index
    })
  }

  handleLanguage(index, chosen)
  {
    this.setState(
      { 
        language: chosen,
        language_Index: index
      })
  }

  handleTheme(index, chosen)
  {
    this.setState(
      { 
        theme: chosen,
        theme_Index: index
      })
  }

  copySwitch = (value) => {
    this.setState({auto_copy: value})
    if (value) this.saveSetting("copySettings", "1")
    else this.saveSetting("copySettings", "0")
  }

  shareSwitch = (value) => {
    this.setState({auto_share: value})
    if (value) this.saveSetting("shareSettings", "1")
    else this.saveSetting("shareSettings", "0")
  }

  deleteSwitch = (value) => {
    this.setState({auto_delete: value})
    if (value) this.saveSetting("deleteSettings", "1")
    else this.saveSetting("deleteSettings", "0")
  }

  saveSetting = async(key, value) => {
    try
    {
      await AsyncStorage.setItem(key, value)
    }
    catch (error)
    {
      alert(error.message)
    }
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

  loadDefaultSettings = async() => {
    var result
    try
    {
      result = await AsyncStorage.getItem("defaultMode")
      if (result !== null)
      {
        if (result !== "1") result = 'encryption'
        else result = 'decryption'
      }
      else result = 'encryption'
    }
    catch (error)
    {
      alert(error.message)
    }
    console.log("Read: " + result)
    this.setState({ mode: result })
  }

  loadLanguageSettings = async() => {
    var result
    try
    {
      result = await AsyncStorage.getItem("language")
      if (result !== null)
      {
        if (result !== "1") result = 'english'
        else result = 'polish'
      }
      else result = 'english'
    }
    catch (error)
    {
      alert(error.message)
    }
    console.log("Read: " + result)
    this.setState({ language: result })
  }

  loadThemeSettings = async() => {
    var result
    try
    {
      result = await AsyncStorage.getItem("theme")
      if (result !== null)
      {
        if (result !== "1") result = 'deep_blue'
        else result = 'banana_white'
      }
      else result = 'deep_blue'
    }
    catch (error)
    {
      alert(error.message)
    }
    console.log("Read: " + result)
    this.setState({ theme: result })
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

  applyButton()
  {
    this.saveSetting("defaultMode", this.state.default_Index.toString())
    this.saveSetting("language", this.state.language_Index.toString())
    this.saveSetting("theme", this.state.theme_Index.toString())
    this.props.navigation.goBack()
  }

  render()
  {
    return (
    <View style = {styles.container}>
      <ScrollView>    
        <View style={styles.rowView}>
          <Text style={styles.switch}>{strings.copy}</Text>
          <MySwitch
            toggleSwitch={this.copySwitch}
            switchValue={this.state.auto_copy}
          />
        </View>
        <View style={styles.rowView}>
          <Text style={styles.switch}>{strings.share}</Text>
          <MySwitch
            toggleSwitch={this.shareSwitch}
            switchValue={this.state.auto_share}
          />
        </View>
        <View style={styles.rowView}>
          <Text style={styles.switch}>{strings.delete}</Text>
          <MySwitch
            toggleSwitch={this.deleteSwitch}
            switchValue={this.state.auto_delete}
          />
        </View>
        <View style={styles.rowView}>
          <Text style={styles.picker}>{strings.mode}</Text>
          <Picker 
          selectedValue={this.state.mode}
          //selectedValue='decryption'
          style={styles.comboBox}
          mode='dropdown'
          onValueChange={(itemValue, itemIndex) => this.handleMode(itemIndex, itemValue)}>
            <Picker.Item label={strings.mode2} value="encryption"/>
            <Picker.Item label={strings.mode1} value="decryption"/>
          </Picker>
        </View>
        <View style={styles.rowView}>
          <Text style={styles.picker}>{strings.lang}</Text>
          <Picker
          name="Language"
          selectedValue={this.state.language}
          style={styles.comboBox}
          mode='dropdown'
          onValueChange={(itemValue, itemIndex) => this.handleLanguage(itemIndex, itemValue)}>
            <Picker.Item label={strings.lang1} value="english"/>
            <Picker.Item label={strings.lang2} value="polish"/>
          </Picker>
        </View>
        <View style={styles.rowView}>
          <Text style={styles.picker}>{strings.theme}</Text>
          <Picker 
          selectedValue={this.state.theme}
          style={styles.comboBox}
          mode='dropdown'
          onValueChange={(itemValue, itemIndex) => this.handleTheme (itemIndex, itemValue)}>
            <Picker.Item label={strings.theme1} value="deep_blue"/>
            <Picker.Item label={strings.theme2} value="banana_white"/>
          </Picker>
        </View>
        <View style={styles.button2}>
          <Button
            title={strings.apply }
            color="#00334C"
            onPress={() => this.applyButton()}
          />
        </View>
      </ScrollView>
    </View>);
  }

};

export default SettingsActivity
