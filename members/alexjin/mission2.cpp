//
//  main.cpp
//  NoBugAlg1
//
//  Created by Jin on 5/23/14.
//  Copyright (c) 2014 Jin. All rights reserved.
//



//Given a sorted array of integers, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//For example,
//
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//
//return [3, 4].

#include <iostream>
using namespace std;


int binarySearch(int array[], int key, int arrayLength){
    int low = 0;
    int high = arrayLength - 1;
    
    
    while (low <= high) {
        int mid = low + (high - low)/2;
        int midVal = array[mid];
        
        if (midVal < key) {
            low = mid + 1;
        }
        else if (midVal > key){
            high = mid - 1;
        }
        else
            return mid; //key found
    }
    
    return -1; //key not found
    
}

int main(int argc, const char * argv[])
{
//    int arrayLength = 0;
//    int keyNumber;
//    int keyPosition;
//    int startPosition;
//    int endPosition;
//    cout<<"Input the length of the array: "<<endl;
//    cin>>arrayLength;
//    int array[arrayLength];
//    for (int i = 0; i<arrayLength; i++) {
//        cout<<"Input a number: "<<endl;
//        cin>>array[i];
//    }
//    cout<<"Please input the key number: "<<endl;
//    cin>>keyNumber;

    int array[6] = {5, 7, 7, 8, 8, 10};
    int keyNumber = 8;
    int startPosition;
    int endPosition;
    int keyPosition;
    int arrayLength = sizeof(array)/sizeof(int);
    
    
    
    cout<<"length: "<<sizeof(array)/sizeof(int)<<endl;
    
    keyPosition = binarySearch(array, keyNumber, arrayLength);
    
    //if target number not found
    if (keyPosition == -1) {
        cout<<"["<<keyPosition<<" , "<<keyPosition<<"]"<<endl;
    }
    //if target number found
    else{
        startPosition = keyPosition;
        endPosition = keyPosition;
        for (int i = keyPosition; i>=0; i--) {
            if (array[i] == keyNumber) {
                startPosition = i;
            }
        }
        
        for (int i = keyPosition; i<=arrayLength-1; i++) {
            if (array[i] == keyNumber) {
                endPosition = i;
            }
        }
        
        cout<<"["<<startPosition<<", "<<endPosition<<"]"<<endl;
    }

    return 0;
}



