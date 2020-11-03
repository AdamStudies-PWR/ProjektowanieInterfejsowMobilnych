import React from 'react'
import { View, Switch }

from 'react-native'

import styles from '../Styles/Styles.js'

export default MySwitch = (props) => {
   return (
      <View style = {styles.switch}>
         <Switch
         onValueChange = {props.toggleSwitch}
         value = {props.switchValue}/>
      </View>
   )
}