// TC: O(n)
// SC: O(1)
class Solution{
  HashMap<Node, Node> map;
  public Node copyRandomList(Node head){
    if(head == null) return null;
    map = new HashMap<>();

    Node copyHead = clone(head);
    Node curr = head;
    Node copyCurr = copyHead;

    while(curr != null){
      copyCurr.next = clone(curr.next);
      copyCurr.random = clone(curr.random);
      curr = curr.next;
      copyCurr = copyCurr.next;
    }
    return copyHead;
  }
  public Node clone(Node node){
    if(node == null) return null;
    if(map.containsKey(node)){
      return map.get(node);
    }
    Node copyNode = new Node(node.val);
    map.put(node, copyNode);
    return copyNode;
  }
}
