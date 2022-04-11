package easy

/**
 * Definition for singly-linked list.
 */
type ListNode struct {
	Val  int
	Next *ListNode
}

//21. Merge Two Sorted Lists
func mergeTwoLists1(list1 *ListNode, list2 *ListNode) *ListNode {
	//early stop when empty
	if list1 == nil && list2 == nil {
		return nil
	}
	root := &ListNode{}
	pre, current := root, root
	for list1 != nil || list2 != nil {
		if list1 == nil || (list2 != nil && list1.Val > list2.Val) {
			current.Val = list2.Val
			current.Next = &ListNode{}
			pre = current
			current = current.Next
			list2 = list2.Next
		} else {
			current.Val = list1.Val
			current.Next = &ListNode{}
			pre = current
			current = current.Next
			list1 = list1.Next
		}
	}
	pre.Next = nil
	//empty
	return root
}
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	var root ListNode
	current := &root
	for list1 != nil && list2 != nil {
		if list1.Val < list2.Val {
			current.Next = list1
			list1 = list1.Next
		} else {
			current.Next = list2
			list2 = list2.Next
		}
		current = current.Next
	}
	if list1 != nil {
		current.Next = list1
	} else {
		current.Next = list2
	}
	//empty
	return root.Next
}
