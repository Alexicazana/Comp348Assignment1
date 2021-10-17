#include <stdlib.h>
#include <stdio.h>

typedef enum { ATOM, LIST } eltype;
typedef char atom;
struct _listnode;

typedef struct {
    eltype type;
    union {
        atom a;
        struct _listnode* l;
    };
} element;


typedef struct _listnode {
    element el;
    struct _listnode* next;
} * list;
const element NIL = { .type=LIST, .l=NULL };

element aasel(atom a)
{
    element e;
    e.type = ATOM;
    e.a = a;
    return e;
}

element lasel(list l)
{
    element e;
    e.type = LIST;
    e.l =  l;
    return e;
}

element car(element e)
{
    if(e.type != LIST)
        return NIL;
    
    return e.l->el;
}

list cdr(element e)
{
    if(e.type != LIST)
        return NULL;

    return e.l->next;
}

list cddr(element e)
{
    return cdr(cdr(e)->el);
}

list cons(element e, list l)
{
    list l2 = (list)malloc(sizeof(struct _listnode));

    l2->el = e;
    l2->next = l;

    return l2;
}

list append(list l1, list l2)
{
    list l;

    l->el = l1->el;
    l->next = l2;

    return l;
}

void lfreer(list l)
{
    if(l != NULL) {
        if(l->next)
            lfreer(l->next);

        free(l);
    }
}

void print(element e)
{
    if(e.type == ATOM)
        printf(" %c ", e.a);

    else {
        printf("(");
        list l = e.l;
        while(l) {
            print(l->el);
            l = l->next;
        }
        
        printf(")");
    }
}

int main()
{
    list l2 = cons(
        lasel(
            cons(
                aasel('b'), 
                cons(aasel('c'), NIL.l)
            )
        ),
        cons(
            aasel('d'),
            cons(aasel('e'), NIL.l)
        )
    );

    list root = cons(aasel('a'), l2);
    print(lasel(root));

    printf("\n");
    
    print(car(lasel(root)));
    printf("\n");
    
    print(lasel(cdr(lasel(root))));


    lfreer(root);

    return 0;
}
