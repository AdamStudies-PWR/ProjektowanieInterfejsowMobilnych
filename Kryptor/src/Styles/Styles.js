import {
  Dimensions,
} from 'react-native';

import { styleSheetFactory } from "./Themes"


const design = styleSheetFactory(theme => (
{
  header:
  {
    backgroundColor: theme.buttonBackground,
  },
  container:
  {
    flex: 1,
    backgroundColor: theme.backgroundColor,
    theme: "light"
  },
  switch:
  {
    flex: 1,
    paddingLeft: 30,
    paddingRight: 30,
    color: theme.textColor
  },
  rowView:
  {
    alignSelf: "center",
    alignContent: "center",
    flexDirection: "row",
    color: theme.textColor,
    paddingTop: 35
  },
  button:
  {
    paddingTop: 10,
    paddingBottom: 10,
    paddingLeft: 15,
    paddingRight: 15,
    backgroundColor: theme.buttonBackground,
    color: theme.textColor,
    //borderStartColor: "green"
  },
  send:
  {
    justifyContent: 'center',
    //alignSelf: "flex-end",
    //marginRight: 15,
    //marginLeft: 15,
    flex: 1,
    backgroundColor: theme.buttonBackground
  },
  messageBox:
  {
    width: Dimensions.get("window").width,
    backgroundColor: theme.backgroundColor,
    position: 'absolute',
    bottom: 0,
    left: 0,
    color: theme.textColor
  },
  textInput:
  {
    alignSelf: "flex-start",
    color: theme.textColor,
    width: '88%'
    //width: (Dimensions.get('window').width - 60)
  },
  textOutput:
  {
    backgroundColor: theme.buttonBackground,
    height: 250,
    marginTop: 20,
    marginLeft: 20,
    marginRight: 20,
    color: theme.textColor
  },
  scrollStyle:
  {
    height: Dimensions.get("window").height - 20,
  },
  comboBox:
  {
    flex: 1,
    marginLeft: 5,
    marginRight: 30,
    color: theme.textColor
  },
  picker:
  {
    flex: 1,
    paddingLeft: 30,
    paddingTop: 18,
    color: theme.textColor
  },
  button2:
  {
    marginTop: 20,
    alignSelf: "center",
    flex: 1,
    width: 150,
    height: 50
  }
}))

export default design
