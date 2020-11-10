import {
  Dimensions,
  StyleSheet
} from 'react-native';

const styles = StyleSheet.create(
{
  container:
  {
    flex: 1,
    backgroundColor: '#00425C'
  },
  switch:
  {
    flex: 1,
    paddingLeft: 30,
    paddingRight: 30
  },
  rowView:
  {
    alignSelf: "center",
    alignContent: "center",
    flexDirection: "row",
    paddingTop: 35
  },
  button:
  {
    paddingTop: 10,
    paddingBottom: 10,
    paddingLeft: 15,
    paddingRight: 15,
    marginLeft: 10,
    marginRight: 10,
    backgroundColor: "#00334C",
    borderStartColor: "green"
  },
  send:
  {
    alignSelf: "flex-end",
    //marginRight: 15,
    //marginLeft: 15,
    flex: 1,
    backgroundColor: "#00334C"
  },
  messageBox:
  {
    width: Dimensions.get("window").width,
    position: 'absolute',
    bottom: 0,
    left: 0
  },
  textInput:
  {
    alignSelf: "flex-start",
    paddingLeft: 15,
    paddingRight: 5,
    //width: (Dimensions.get('window').width - 60)
  },
  textOutput:
  {
    backgroundColor: '#00334C',
    height: 250,
    marginTop: 20,
    marginLeft: 20,
    marginRight: 20,
  },
  scrollStyle:
  {
    height: Dimensions.get("window").height - 20,
  },
  comboBox:
  {
    flex: 1,
    marginLeft: 5,
    marginRight: 30
  },
  picker:
  {
    flex: 1,
    paddingLeft: 30,
    paddingRight: 30,
    paddingTop: 18
  },
  button2:
  {
    paddingTop: 40,
  }
});

export default styles