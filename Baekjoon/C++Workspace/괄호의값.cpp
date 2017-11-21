#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main(int argc, char const *argv[]) {
  string inputStr;
  stack<int> st;
  int count = 0;
  cin >> inputStr;
  for(int i=0; i<inputStr.length(); i++){
      if(inputStr[i] == '('){
        st.push(-1);
      }
      else if(inputStr[i] == '['){
        st.push(-2);
      }
      else if(inputStr[i] == ')'){
        bool flag = false;
        int tempValue = 0;
        if(st.size() == 0||st.top() == -2){
          cout << '0';
          return 1;
        }
        while(st.top() != -1){
            if(st.top() == -2){
              cout << '0';
              return 1;
            }
            flag = true;
            tempValue += st.top();
            st.pop();
        }
        st.pop();
        if(flag){
          st.push(2*tempValue);
        }
        else{
          st.push(2);
        }
      }
      else if(inputStr[i] == ']'){
        bool flag = false;
        int tempValue = 0;
        if(st.size() == 0||st.top() == -1){
          cout << '0';
          return 1;
        }
        while(st.top() != -2){
            if(st.top() == -1){
              cout << '0';
              return 1;
            }
            flag = true;
            tempValue += st.top();
            st.pop();
        }
        st.pop();
        if(flag){
          st.push(3 * tempValue);
        }
        else{
          st.push(3);
        }
      }
  }
  int size = st.size();
  bool isNotCorrect = false;
  for(int i=0; i<size; i++){
    if(st.top() < 0){
      isNotCorrect = true;
    }
    else{
      count += st.top();
      st.pop();
    }
  }
  if(count < 0 || isNotCorrect){
      cout << 0 << endl;
  }
  else{
    cout << count << endl;
  }
  return 0;
}
