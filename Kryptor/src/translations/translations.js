import LocalizedStrings from 'react-native-localization';
import polish from './pl.json'
import english from './en.json'

const strings = new LocalizedStrings({
  en: english,
  pl: polish
});

export default strings
