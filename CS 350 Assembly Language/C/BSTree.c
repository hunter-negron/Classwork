#include <stdio.h>
#include <malloc.h>

// Structure Definitions
struct Node {
     int value;
     struct Node* leftChild;
     struct Node* rightChild;
};

struct bTree {
     struct Node* root;
};

// New Tree
struct bTree* newTree(int value) {
	struct Node* root = (struct Node*) malloc(sizeof(struct Node));
	struct bTree* bt = (struct bTree*) malloc(sizeof(struct bTree));
	
	if(root == NULL || bt == NULL) {
		return NULL;
	}
	
	root->value = value;
	bt->root = root;
	return bt;
}

// Add Values
int add(struct bTree* root, int value) {
	struct Node* s = root->root;
	
	while(1) {
		if(value <= s->value && s->leftChild == NULL) {
			s->leftChild = (struct Node*) malloc(sizeof(struct Node));
			if(s == NULL) {
				return 0; // Failure
			}
			s->leftChild->value = value;
			return 1; // Successful
		}
		else if(value <= s->value && s->leftChild != NULL) {
			s = s->leftChild;
			continue;
		}
		else if(value > s->value && s->rightChild == NULL) {
			s->rightChild = (struct Node*) malloc(sizeof(struct Node));
			if(s == NULL) {
				return 0; // Failure
			}
			s->rightChild->value = value;
			return 1; // Successful		
		}
		else if(value > s->value && s->rightChild != NULL) {
			s = s->rightChild;
			continue;
		}
	}
}

// Test Containment
int contain(struct bTree* root, int value) {
	struct Node* s = root->root;
	
	while(s != NULL) {
		if(s->value == value) {
			return 1; // successfully found
		}
		else if(value < s->value) {
			s = s->leftChild;
		}
		else {
			s = s->rightChild;
		}
	}
	
	return 0; // Failed to find
}

// Assistant Fuction For RemoveNode()
struct Node* del_rec(struct Node* n, int v) {
	if(n == NULL) {
		return NULL;
	}
	else if(v < n->value) {
		n->leftChild = del_rec(n->leftChild, v);
		return n;
	}
	else if(v > n->value) {
		n->rightChild = del_rec(n->rightChild, v);
		return n;
	}
	else {
		if(n->leftChild == NULL && n->rightChild == NULL) {
			return NULL;
		}
		else if(n->leftChild != NULL && n->rightChild == NULL) {
			return n->leftChild;
		}
		else if(n->leftChild == NULL && n->rightChild != NULL) {
			return n->rightChild;
		}
		else {
			struct Node* to_del = n->leftChild;
			if(to_del->rightChild == NULL) {
				n->leftChild = to_del->leftChild;
			}
			else {
				struct Node* p = to_del;
				to_del = p->rightChild;
				while(to_del->rightChild != NULL) {
					to_del = to_del->rightChild;
					p = p->rightChild;
				}
				p->rightChild = to_del->leftChild;
			}
			n->value = to_del->value;
			free(to_del); // use free() to release the memory
			return n;
		}
	}
}

// Remove Value
int removeNode(struct bTree* root, int value) {
	if(!contain(root, value)) {
		return 0; // Value not found
	}
	
	root->root = del_rec(root->root, value);

	return 1; // Successfully removed
}

// Assistant Function For PrintTree()
void printInorder(struct Node* node) { 
	if (node == NULL) {
		return;
	}
  
	printInorder(node->leftChild);
	printf("%d ", (node->value));
	printInorder(node->rightChild); 
}


// Print Values
int printTree (struct bTree* root) {
	printInorder(root->root);
	printf("\n");
}

// Tests
int main () {
	// TEST CASE 1
	struct bTree* root = newTree(72);
	add(root, 12);
	add(root, 52);
	add(root, 87);
	add(root, 18);
	add(root, 49);
	add(root, 43);
	add(root, 82);
	add(root, 34);
	add(root, 73);
	add(root, 21);

	printTree(root);

	if(contain(root, 73) == 1){
		printf("This tree contains 73\n");
	}else{
		printf("This tree doesn't contain 73\n");
	}
	
	if(contain(root, 22) == 1){
		printf("This tree contains 22\n");
	}else{
		printf("This tree doesn't contain 22\n");
	}

	removeNode(root, 18);
	printf("After delete 18\n");
	printTree(root);

	removeNode(root, 49);
	printf("After delete 49\n");
	printTree(root);
	
	// TEST CASE 2
	struct bTree* root2 = newTree(100);
	add(root2, 99);
	add(root2, 101);
	add(root2, 98);
	add(root2, 102);
	add(root2, 97);
	add(root2, 103);
	add(root2, 96);
	add(root2, 104);
	add(root2, 95);
	add(root2, 105);

	printTree(root2);

	if(contain(root2, 11) == 1){
		printf("This tree contains 11\n");
	}else{
		printf("This tree doesn't contain 11\n");
	}
	
	if(contain(root2, 105) == 1){
		printf("This tree contains 105\n");
	}else{
		printf("This tree doesn't contain 105\n");
	}

	removeNode(root2, 12);
	printf("After delete 12\n");
	printTree(root2);

	removeNode(root2, 99);
	printf("After delete 99\n");
	printTree(root2);
	
	
	return 0;
}


