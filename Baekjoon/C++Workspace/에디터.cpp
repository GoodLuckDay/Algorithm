#include <iostream>
#include <vector>

using std::cout;
using std::cin;
using std::endl;
using std::string;
using std::vector;

int main(){
    vector<char> line;
    int cursorPos;
    int N;
    string inputStr;
    string command;

    getline(cin,inputStr);
    cursorPos = inputStr.size();
    for(string::iterator iter = inputStr.begin(); iter != inputStr.end(); ++iter){
        line.push_back(*iter);
    }

    cin >> N;
    cin.ignore();
    for(int i=0; i<N; i++){
        getline(cin, command);
        if(command[0] == 'P'){
            line.insert(line.begin()+cursorPos, command[2]);
            cursorPos++;
        }
        else if(command[0] == 'D'){
            cursorPos = (cursorPos < line.size()) ? cursorPos + 1 : line.size();
        }
        else if(command[0] == 'B'){
            if(cursorPos != 0){
                cursorPos--;
                line.erase(line.begin() + cursorPos);
            }
        }
        else if(command[0] == 'L'){
            cursorPos = (cursorPos > 0) ? cursorPos - 1 : 0;
        }
    }
    for(vector<char>::iterator iter = line.begin(); iter != line.end(); iter++){
        cout << *iter;
    }
    cout << endl;

}