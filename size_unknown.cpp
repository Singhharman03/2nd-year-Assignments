#include <iostream>  //Name : Harman Singh
using namespace std; // ECE SID : 21105003

/*
QUESTION:How would you search for an element in an array/list whose size is unknown?
SOLUTION: We can search an element in an array whose size is unknown in O(logn) time complexity provided that the array is in sorted order (here i am taking case of ascending order).We can do this by making some modification in binary search technique.
The concept behind this approach is:
  ->Take inital value of start as 0 and end as 1.
  ->Now increase end to end*2 until arr[end] exceed the key to be searched.
  ->Now search the key using binary search between start and end.
*/

// Enhanced binary search function or Binary search for array with unknown lenght
void binary_search_unknown(int arr[], int key)
{
    // Initializing i as 0 and end as 1.
    int start = 0, end = 1;
    // We will increase end until arr[end] exceeds key to be searched.
    while (arr[end] < key)
    {
        start = end;
        end = 2 * end;
    }
    // Now calling Simple Binary Search on range i to end.

    // Binary Search between start and end
    int mid = (start + end) / 2; // mid = middle element
    bool found=false;
    while (start <= end)
    { // start = starting index and end = ending index
        if (arr[mid] == key)
        {
            found=true;
            break;
        } // if key to be searched is present we will return index of the key
        else
        {
            if (arr[mid] < key)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        mid = (start + end) / 2;
    }
    if(found){
        cout<<mid<<endl;
    }
    else{
        cout<<"Not Found"<<endl;
    }
}