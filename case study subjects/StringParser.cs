bool cascade = false , inValue = false;
String currentValue = "";
List <String > values = new List <String >();
for (int i = 0; i < s.Length; i++) {
char c = s[i];

if (c =='\\' && !cascade) { 

cascade = !cascade; }

else if (c == ''' && !cascade) { 

inValue = !inValue; }

else if (c == ',')
 { 
 
 values.Add(currentValue); currentValue = "";}
 
 else { 
 
 currentValue += c; }
 cascade = false;
 
 }
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 