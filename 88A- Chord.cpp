
 
#include <iostream>
#include <algorithm>
#include <bits/stdc++.h>
 
using namespace std;
map<string, int> mp;
int dist(string x, string y) {
 return (mp[y] - mp[x] + 12) % 12;
}
int main() {
 
 mp["C"] = 0;
 mp["C#"] = 1;
 mp["D"] = 2;
 mp["D#"] = 3;
 mp["E"] = 4;
 mp["F"] = 5;
 mp["F#"] = 6;
 mp["G"] = 7;
 mp["G#"] = 8;
 mp["A"] = 9;
 mp["B"] = 10;
 mp["H"] = 11;
 string a[3];
 cin >> a[0] >> a[1] >> a[2];
 sort(a, a + 3);
 bool done = false;
 
 do {
 
  if (dist(a[0], a[1]) == 3 && dist(a[1], a[2]) == 4) {
   cout << "minor" << endl;
   done = true;
   break;
  } else if (dist(a[0], a[1]) == 4 && dist(a[1], a[2]) == 3) {
 
   cout << "major" << endl;
   done = true;
   break;
  }
 
 }while (next_permutation(a, a + 3));
 
 if (!done)
  cout << "strange" << endl;
 
 
 return 0;
}
