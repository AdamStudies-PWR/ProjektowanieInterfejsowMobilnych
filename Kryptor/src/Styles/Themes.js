import { registerThemes } from "react-native-themed-styles"

const deepBlue = { 
    backgroundColor: '#00425C',
    buttonBackground: '#00334C',
    textColor: "white" 
}
const bananaWhite = { 
    backgroundColor: '#FFFFCC',
    buttonBackground: '#ffff00',
    textColor: "black" 
}

const styleSheetFactory = registerThemes(
  { deepBlue, bananaWhite },
  //() => "bananaWhite"
  () => "deepBlue"
)

export { styleSheetFactory }