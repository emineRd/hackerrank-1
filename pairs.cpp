// Solution for HackerRank Problem "PAIRS"
#include<iostream>
#include<vector>
#include<algorithm>
#define f(i,n) for(i=0;i<n;i++)

using namespace std;

int getDiff(int N,int K,vector<int> V)
{
    int result=0,i=0;
    make_heap (V.begin(),V.end());
    sort_heap (V.begin(),V.end());
    vector<int>::iterator b=V.begin();
    f(i,N)
    {
        b=V.begin();
        advance (b,i);
        if(binary_search(V.begin(),V.end(),(V[i]+K)))
        {
            result++;
        }
    }
    return result;
}
int main()
{
    int i=0,N,K,temp;
    cin>>N>>K;
    vector<int> V;
    f(i,N)
    {
        cin>>temp;
        V.push_back(temp);
    }
    int result = getDiff(N,K,V);
    cout<<result;
    return 0;
}