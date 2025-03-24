#include <cstdlib>
#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    bool hasCycle(ListNode *head) {
        if (head == NULL || head->next == NULL) {
            return false;
        }

        ListNode* slow = head;
        ListNode* fast = head->next;

        while (fast != NULL) {
            if (fast->next != NULL) {
                fast = fast->next->next;
            }

            slow = slow->next;

            if (fast == slow) {
                return true;
            }            
        }
    }
};

int main() {
    Solution solution;
    
    // Test case 1: [3,2,0,-4], pos = 1
    ListNode* head1 = new ListNode(3);
    head1->next = new ListNode(2);
    head1->next->next = new ListNode(0);
    head1->next->next->next = new ListNode(-4);
    head1->next->next->next->next = head1->next;  // Create cycle to position 1
    cout << "Test 1: " << boolalpha << solution.hasCycle(head1) << endl;

    // Test case 2: [1,2], pos = 0
    ListNode* head2 = new ListNode(1);
    head2->next = new ListNode(2);
    head2->next->next = head2;  // Create cycle to position 0
    cout << "Test 2: " << boolalpha << solution.hasCycle(head2) << endl;

    // Test case 3: [1], pos = -1
    ListNode* head3 = new ListNode(1);
    cout << "Test 3: " << boolalpha << solution.hasCycle(head3) << endl;

    return 0;
}