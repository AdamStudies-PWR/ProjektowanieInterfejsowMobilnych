import 'react-native-gesture-handler';
import VersionNumber from 'react-native-version-number';
import React from 'react';

import {
  Text,
  View
} from 'react-native';
import { ScrollView } from 'react-native-gesture-handler';

import styles from '../Styles/Styles.js';
import Converter from '../modules/Converter.js';
import { Component } from 'react';

class AboutActivity extends Component
{
  constructor()
  {
    super()
    this.state = {
      appVersion: VersionNumber.appVersion,
      kryptoVersion: "unknown"
    }
    this.loadData()
  }

  loadData = async() => {
    try
    {
      var version = await Converter.getVersion()
      this.setState({ kryptoVersion: version })
    }
    catch(error)
    {
      console.error(error)
    }
  }

  render()
  {
    return (
    <View style = { styles.container }>
      <ScrollView>    
        <View style={styles.rowView}>
          <Text style = {styles.switch}>Author: </Text>
          <Text style = {styles.switch}>Adam Krizar 241276</Text>
        </View>
        <View style={styles.rowView}>
          <Text style = {styles.switch}>KryptoEngine version: </Text>
          <Text style = {styles.switch}>{this.state.kryptoVersion}</Text>
        </View>
        <View style={styles.rowView}>
          <Text style = {styles.switch}>App version: </Text>
          <Text style = {styles.switch}>{this.state.appVersion}</Text>
        </View>
      </ScrollView>
    </View>);
  }

}

export default AboutActivity