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
    paddingLeft: 15,
    flex: 1,
    backgroundColor: "#00334C"
  },
  messageBox:
  {
    //position: 'absolute',
    //height: 40,
    //left: 0, 
    //top: Dimensions.get("window").height - 40, 
    //width: Dimensions.get(window).width
  }
});

export default styles