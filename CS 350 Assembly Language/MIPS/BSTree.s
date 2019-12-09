.data
    msg1:       .asciiz "This tree contains: "
    msg2:       .asciiz "This tree doesn't contain: "
    msg3:       .asciiz "After delete: "
    newline:    .asciiz "\n"
    space:	    .asciiz " "

.text
.globl main
# this main section contains the test cases for the methods
main:
    # Test NewTree
	li $a0, 72         # struct bTree* btree = newTree(72);
	jal newTree
	move $t0, $v0      # copy the address of bTree to t0

    # Test AddNode
	move $a0, $t0		# add(root, 12);
	li $a1, 12
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal addNode
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

	move $a0, $t0		# add(root, 52);
	li $a1, 52
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal addNode
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

	move $a0, $t0		# add(root, 87);
	li $a1, 87
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal addNode
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

	move $a0, $t0		# add(root, 18);
	li $a1, 18
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal addNode
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

	move $a0, $t0		# add(root, 49);
	li $a1, 49
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal addNode
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

    # Test PrintTree
	move $a0, $t0		# printTree(bTree);
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal printTree		#
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

    #
    # THIS TEST CONTAINS(18)
    # A VALUE IN THE TREE
    #
	move $a0, $t0		# contains(root, 18);
	li $a1, 18
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal contains
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

    # This is a highly compressed if-statement
    beqz $v0, nc1
    la $a0, msg1
	li $v0, 4
	syscall
    j a1
    nc1:
    la $a0, msg2
	li $v0, 4
	syscall
    a1:
	li $a0, 18		# get the current node's value
	li $v0, 1
	syscall
    la $a0, newline		# printf("\n");
	li $v0, 4
	syscall

    #
    # THIS TEST CONTAINS(87)
    # A VALUE IN THE TREE
    #
	move $a0, $t0		# contains(root, 18);
	li $a1, 87
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal contains
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

    # This is a highly compressed if-statement
    beqz $v0, nc2
    la $a0, msg1
	li $v0, 4
	syscall
    j a2
    nc2:
    la $a0, msg2
	li $v0, 4
	syscall
    a2:
	li $a0, 87		# get the current node's value
	li $v0, 1
	syscall
    la $a0, newline		# printf("\n");
	li $v0, 4
	syscall

    #
    # THIS TEST CONTAINS(1)
    # A VALUE NOT IN THE TREE
    #
	move $a0, $t0		# contains(root, 18);
	li $a1, 1
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal contains
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

    # This is a highly compressed if-statement
    beqz $v0, nc3
    la $a0, msg1
	li $v0, 4
	syscall
    j a3
    nc3:
    la $a0, msg2
	li $v0, 4
	syscall
    a3:
	li $a0, 1		# get the current node's value
	li $v0, 1
	syscall
    la $a0, newline		# printf("\n");
	li $v0, 4
	syscall

    #
    # THIS TEST CONTAINS(100)
    # A VALUE NOT IN THE TREE
    #
	move $a0, $t0		# contains(root, 18);
	li $a1, 100
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal contains
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

    # This is a highly compressed if-statement
    beqz $v0, nc4
    la $a0, msg1
	li $v0, 4
	syscall
    j a4
    nc4:
    la $a0, msg2
	li $v0, 4
	syscall
    a4:
	li $a0, 100		# get the current node's value
	li $v0, 1
	syscall
    la $a0, newline		# printf("\n");
	li $v0, 4
	syscall

    #
    # TEST DELETE(18)
    # A VALUE IN THE TREE
    #
	move $a0, $t0		# deleteNode(root, 18);
	li $a1, 18
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal deleteNode
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

    # Print the message
	la $a0, msg3
	li $v0, 4
	syscall

    # Print the tree
	move $a0, $t0		# printTree(bTree);
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal printTree		#
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

    #
    # TEST DELETE(87)
    # A VALUE IN THE TREE
    #
	move $a0, $t0		# deleteNode(root, 87);
	li $a1, 87
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal deleteNode
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

    # Print the message
	la $a0, msg3
	li $v0, 4
	syscall

    # Print the tree
	move $a0, $t0		# printTree(bTree);
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal printTree		#
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

    #
    # TEST DELETE(1)
    # A VALUE NOT IN THE TREE
    #
	move $a0, $t0		# deleteNode(root, 1);
	li $a1, 1
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal deleteNode
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

    # Print the message
	la $a0, msg3
	li $v0, 4
	syscall

    # Print the tree
	move $a0, $t0		# printTree(bTree);
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal printTree		#
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

    #
    # TEST DELETE(100)
    # A VALUE NOT IN THE TREE
    #
	move $a0, $t0		# deleteNode(root, 100);
	li $a1, 100
	subu $sp, $sp, 4	# adjust the stack pointer
	sw $t0, 0($sp) 		# save the parameter
	jal deleteNode
	lw $t0, 0($sp) 		# get the return address
	addu $sp, $sp, 4 	# adjust the stack pointer

	li $v0, 10		# exit the program
	syscall

# creates a new tree given a value for the first node
# input: $a0 is the value for the first node
# returns a reference to the new binary tree
newTree:
	move $t0, $a0		# copy the value of the root node to t0

	addiu $sp, $sp, -4 	# adjust the stack pointer
	sw $ra, 0($sp) 		# PUSH the return address on stack
	addiu $sp, $sp, -4	# adjust the stack pointer
	sw $a0, 0($sp) 		# PUSH the parameter

    # struct Node* root = (struct Node*) malloc(sizeof(struct Node));
	li $a0, 3		    # (struct Node*)malloc(sizeof(struct Node));
	jal malloc          # create a 3 words length space for root node
	move $t1, $v0		# copy the address of root node to t1

    # root->value = value;
    sw $t0, 0($t1)
    li $t2, 0
    sw $t2, 8($t1)		# root->rightChild = NULL;
    sw $t2, 4($t1)		# root->leftChild = NULL;

    # struct bTree* bt = (struct bTree*) malloc(sizeof(struct bTree));
	li $a0, 1		    # (struct bTree*)malloc(sizeof(struct bTree));
	jal malloc		    # create a 1 word length space for bTree
	move $t2, $v0		# copy the address of root node to t2

    # bTree->root = root;
	sw $t1, 0($t2)		# because t1 holds the address of the root node

	lw $a0, 0($sp) 		# POP the parameter
	addiu $sp, $sp, 4	# adjust the stack pointer
	lw $ra, 0($sp) 		# POP the return address
	addiu $sp, $sp, 4 	# adjust the stack pointer

    # return the binary tree
    move $v0, $t2		# set the return value to v0
    jr $ra

# adds a new node value to the tree
# input: $a0 is the address to the binary tree
#        $a1 is the value of the new node
addNode:
    addiu $sp, $sp, -4 	# adjust the stack pointer
    sw $ra, 0($sp) 		# PUSH the return address on stack
    addiu $sp, $sp, -4	# adjust the stack pointer
    sw $a0, 0($sp) 		# PUSH the binary tree
    addiu $sp, $sp, -4	# adjust the stack pointer
    sw $a1, 0($sp) 		# PUSH the new value

    # struct Node* s = root->root;
    lw $t0, 0($a0)      # t0 holds a pointer to the root node

    addNodeWhile:
        lw $t1, 0($t0)  # t1 holds node value
        lw $t2, 4($t0)  # t2 holds left child
        lw $t3, 8($t0)  # t3 holds right child

        # THE FOLLOWING CODE SIMULATES A 4-PART IF-ELSE STATEMENT
        ble $a1, $t1, addNodeLessEqual

        # If new value > node value
            beqz $t3, null_1

            # If the right child is not null
                move $t0, $t3
                j addNodeWhile

            # If the right child is null
            null_1:
                addiu $sp, $sp, -4 	# adjust the stack pointer
                sw $t0, 0($sp) 		# PUSH the current node onto the stack

                # s->rightChild = (struct Node*) malloc(sizeof(struct Node));
                li $a0, 3		    # (struct Node*)malloc(sizeof(struct Node));
                jal malloc          # create a 3 words length space for root node
                move $t1, $v0		# copy the address of root node to t1

                lw $t0, 4($sp)      # get the new value off of the stack

                # s->rightchild->value = value;
                sw $t0, 0($t1)
                li $t2, 0
                sw $t2, 8($t1)		# root->rightChild = NULL;
                sw $t2, 4($t1)		# root->leftChild = NULL;

                # add this new node as the right child
                lw $t9, 0($sp)      # POP the current node off of the stack
                addiu $sp, $sp, 4   # adjust the stack pointer
                sw $t1, 8($t9)      # set right child of node to new node

                j addNodeEnd

        # If new value <= node value
        addNodeLessEqual:
            beqz $t2, null_2

            # If the left child is not null
                move $t0, $t2
                j addNodeWhile

            # If the left child is null
            null_2:
                addiu $sp, $sp, -4 	# adjust the stack pointer
                sw $t0, 0($sp) 		# PUSH the current node onto the stack

                # s->rightChild = (struct Node*) malloc(sizeof(struct Node));
                li $a0, 3		    # (struct Node*)malloc(sizeof(struct Node));
                jal malloc          # create a 3 words length space for root node
                move $t1, $v0		# copy the address of root node to t1

                lw $t0, 4($sp)      # get the new value off of the stack

                # s->rightchild->value = value;
                sw $t0, 0($t1)
                li $t2, 0
                sw $t2, 8($t1)		# root->rightChild = NULL;
                sw $t2, 4($t1)		# root->leftChild = NULL;

                # add this new node as the right child
                lw $t9, 0($sp)      # POP the current node off of the stack
                addiu $sp, $sp, 4   # adjust the stack pointer
                sw $t1, 4($t9)      # set right child of node to new node

                j addNodeEnd

    j addNodeWhile

    addNodeEnd:
        lw $a1, 0($sp) 		# POP the return address on stack
        addiu $sp, $sp, 4 	# adjust the stack pointer
        lw $a0, 0($sp) 		# POP the binary tree
        addiu $sp, $sp, 4	# adjust the stack pointer
        lw $ra, 0($sp) 		# POP the new value
        addiu $sp, $sp, 4	# adjust the stack pointer
    jr $ra

# a boolean method that checks if the tree contains a value
# input: $a0 is the address to the binary tree
#        $a1 is the address to be found in the tree
# returns 1 if the value is found, 0 if not
contains:
    addiu $sp, $sp, -4 	# adjust the stack pointer
    sw $ra, 0($sp) 		# PUSH the return address on stack
    addiu $sp, $sp, -4	# adjust the stack pointer
    sw $a0, 0($sp) 		# PUSH the binary tree
    addiu $sp, $sp, -4	# adjust the stack pointer
    sw $a1, 0($sp) 		# PUSH the new value

    # struct Node* s = root->root;
    lw $t0, 0($a0)      # t0 holds a pointer to the root node
    move $v0, $zero     # returns false by default

    containsWhile:
        beqz $t0, containsEnd   # terminal case for the loop

        lw $t1, 0($t0)  # t1 holds node value
        lw $t2, 4($t0)  # t2 holds left child
        lw $t3, 8($t0)  # t3 holds right child

        blt $a1, $t1, containsLessThan
        bgt $a1, $t1, containsGreaterThan

        # If value = node value
            li $v0, 1   # return true
            j containsEnd

        # If value < node Value
        containsLessThan:
            move $t0, $t2   # s = s->leftChild;
            j containsWhile

        # If value > node Value
        containsGreaterThan:
            move $t0, $t3   # s = s->rightChild;
            j containsWhile


    containsEnd:
        lw $a1, 0($sp) 		# POP the return address on stack
        addiu $sp, $sp, 4 	# adjust the stack pointer
        lw $a0, 0($sp) 		# POP the binary tree
        addiu $sp, $sp, 4	# adjust the stack pointer
        lw $ra, 0($sp) 		# POP the new value
        addiu $sp, $sp, 4	# adjust the stack pointer
    jr $ra

# recursive helper fuction for deleteNode()
# input: $a0 is an address for a node
#        $a1 is the value to be removed
# returns an updated node
delRec:
    addiu $sp, $sp, -4 	# adjust the stack pointer
    sw $ra, 0($sp) 		# PUSH the return address on stack
    addiu $sp, $sp, -4	# adjust the stack pointer
    sw $a0, 0($sp) 		# PUSH the root node
    addiu $sp, $sp, -4	# adjust the stack pointer
    sw $a1, 0($sp) 		# PUSH the new value

    beq $a0, $zero, delRecNodeIsNull    # if(node == NULL)
    lw $t0, 0($a0)                      # n.value
    blt $a1, $t0, delRecValueIsLess     # if (value < node.value)
    bgt $a1, $t0, delRecValueIsMore     # if (value > node.value)

    # else: the case that the value equals the node value
        lw $s0, 4($a0)      # $s0 is left child
        lw $s1, 8($a0)      # $s1 is right child

        beqz $s0, delRecLeftChildIsNull
        beqz $s1, delRecRightChildIsNull

        #else: the case that neither of the children are null
            move $s3, $s0   # struct Node* to_del = n->leftChild;
            lw $t0, 8($s3)  # to_del->rightChild
            beqz $t0, delRecRightChildOfLeftChildIsNull # if(to_del->rightChild == NULL)

            # else: the right child of the left child is null
                move $s4, $s3       # struct Node* p = to_del;
                lw $s3, 8($s4)      # to_del = p->rightChild;
                delRecWhile:
                    lw $t0, 8($s3)  # to_del->rightChild
                    beqz $t0, delRecAfterWhile  # if to_del->rightChild == NULL, BREAK
                    lw $s3, 8($s3)  # to_del = to_del->rightChild;
                    lw $s4, 8($s4)  # p = p->rightChild;
                    j delRecWhile

                delRecAfterWhile:
                    lw $t0, 4($s3)  # to_del->leftChild;
                    sw $t0, 8($s4)  # p->rightChild = to_del->leftChild;

                j delRecAfterIf

            delRecRightChildOfLeftChildIsNull:
                # n->leftChild = to_del->leftChild;
                lw $t0, 4($s3)
                sw $t0, 4($s0)

                j delRecAfterIf

            delRecAfterIf:
                lw $t0, 0($s3)  # to_del->value;
                sw $t0, 0($s0)  # n->value = to_del->value;

                # free(to_del);
                move $a0, $s3   # #s3 holds the address of the node to delete
                li $a1, 3     # 3 words because that is the size of a node
                jal free

                lw $v0, 4($sp)  # return n;

                j delRecEnd

        # left is null, right could be either
        delRecLeftChildIsNull:
            beqz $s1, delRecBothChildrenAreNull
            # only the left is null
            move $v0, $s1   # return the right child
            j delRecEnd

        # only the right is null
        delRecRightChildIsNull:
            move $v0, $s0   # return the left child
            j delRecEnd

        # left and right children are null
        delRecBothChildrenAreNull:
            move $v0, $zero # return NULL
            j delRecEnd

    delRecNodeIsNull:
        move $v0, $zero     # return null
        j delRecEnd

    delRecValueIsLess:
        lw $a0, 4($a0)      # get the left child
        jal delRec
        # then update the root node with the new address
        lw $t0, 4($sp)      # get the root node off of the stack
        sw $v0, 4($t0)      # store the new left node
        # return n
        move $v0, $t0
        j delRecEnd


    delRecValueIsMore:
        lw $a0, 8($a0)      # get the right child
        jal delRec
        # then update the root node with the new address
        lw $t0, 4($sp)      # get the root node off of the stack
        sw $v0, 8($t0)      # store the new right node
        # return n
        move $v0, $t0
        j delRecEnd

    delRecEnd:
        lw $a1, 0($sp) 		# POP the return address on stack
        addiu $sp, $sp, 4 	# adjust the stack pointer
        lw $a0, 0($sp) 		# POP the root node
        addiu $sp, $sp, 4	# adjust the stack pointer
        lw $ra, 0($sp) 		# POP the new value
        addiu $sp, $sp, 4	# adjust the stack pointer
        jr $ra

# delete a node from the tree, uses the free()
# method to deallocate the memory
# input: $a0 is the address to the binary tree
#        $a1 is the value to be deleted from the tree
deleteNode:
    addiu $sp, $sp, -4 	# adjust the stack pointer
    sw $ra, 0($sp) 		# PUSH the return address on stack
    addiu $sp, $sp, -4	# adjust the stack pointer
    sw $a0, 0($sp) 		# PUSH the binary tree
    addiu $sp, $sp, -4	# adjust the stack pointer
    sw $a1, 0($sp) 		# PUSH the new value

    # Test containment first; fail if value not found
    # Since contains takes the same parameters, we are ready to jump
    jal contains
    bnez $v0, delSuccess

    # Exit with error value '0'
    move $v0, $zero
    j delNodeEnd

    delSuccess:
    # first get a reference to the root node with value removeNode
    lw $a0, 0($a0) # delrec takes a node as an argument
                   # $a1 already contains the integer Value
    jal delRec
    # then update the root node of the tree with the new address
    lw $t0, 4($sp) # get the tree off of the stack
    sw $v0, 0($t0) # store the new root into the tree

    li $v0, 1      # return 1 for success

    # end the fuction
    delNodeEnd:
    lw $a1, 0($sp) 		# POP the return address on stack
    addiu $sp, $sp, 4 	# adjust the stack pointer
    lw $a0, 0($sp) 		# POP the binary tree
    addiu $sp, $sp, 4	# adjust the stack pointer
    lw $ra, 0($sp) 		# POP the new value
    addiu $sp, $sp, 4	# adjust the stack pointer
    jr $ra

# print the tree
# input: $a0 the address of the tree
printTree:
	addiu $sp, $sp, -4 	# adjust the stack pointer
	sw $ra, 0($sp) 		# PUSH the return address on stack
	addiu $sp, $sp, -4	# adjust the stack pointer
	sw $a0, 0($sp) 		# PUSH the parameter (address of tree)

    lw $a0, 0($a0)		# printInorder(bTree->root);
    jal printInOrder

	lw $a0, 0($sp) 		# POP the parameter
	addiu $sp, $sp, 4	# adjust the stack pointer
	lw $ra, 0($sp) 		# POP the return address
	addiu $sp, $sp, 4 	# adjust the stack pointer

    la $a0, newline		# printf("\n");
	li $v0, 4
	syscall

    jr $ra

# recurive helper fuction for printTree()
# input: $a0 the address of the root node
printInOrder:
    move $t0, $a0           # t0 holds the node address
    bne $t0, 0, printElse   # if node == null,  return
    jr $ra              	# to return
printElse:
	# printInOrder(node->leftChild);
	addiu $sp, $sp, -4 	# adjust the stack pointer
	sw $ra, 0($sp) 		# PUSH the return address on stack
	addiu $sp, $sp, -4	# adjust the stack pointer
	sw $t0, 0($sp)		# PUSH the parameter on stack

    lw $a0, 4($t0)      # get the address for left child
	jal printInOrder    # printInorder(node->leftChild);
    lw $t0, 0($sp)      # get the node address back

    # printf("%d ", (node->value));
	lw $a0, 0($t0)		# get the current node's value
	li $v0, 1
	syscall             # print value
	la $a0, space
	li $v0, 4
	syscall             # print space

    # printInOrder(node->leftChild);
    lw $a0, 8($t0)      # get the address for left child
	jal printInOrder    # printInorder(node->leftChild);
    lw $t0, 0($sp)      # get the node address back

    lw $a0, 0($sp) 		# POP the parameter
	addiu $sp, $sp, 4	# adjust the stack pointer
	lw $ra, 0($sp) 		# POP the return address
	addiu $sp, $sp, 4 	# adjust the stack pointer

    jr $ra

# dynamically allocated memory block
# input: $a0 the size of memory block in words
# output: $v0 the address to the allocated memory
malloc:
	mul $a0, $a0, 4 # the number of bytes you need.
	li $v0,9      # allocate memory
	syscall

	jr $ra

# free the memory block, here we can simply set
# all bits of the memory blocks to be zero
# input: $a0 the address of memory block
# $a1 the size of memory block in words
free:
    freeWhile:
        beqz $a1, freeEnd
        addiu $a1, $a1, -1       # decrement the counter
        sw $zero, 0($a0)    # overwrite the word with zeros
        addiu $a0, $a0, 32  # 1 word is 32 bits
        j freeWhile
    freeEnd:
        jr $ra
