import React from 'react'
import { View, Switch }

from 'react-native'

import styles from '../Styles/Styles.js'

export default MySwitch = (props) => {
   return (
      <View>
         <Switch
         onValueChange = {props.toggleSwitch}
         value = {props.switchValue}/>
      </View>
   )
}

//  style = {styles.switch}
