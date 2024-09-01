#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_TITLE_LENGTH 50
#define MAX_AUTH_LENGTH 50
#define MAX_BOOKS 100

struct Book {
    char title[MAX_TITLE_LENGTH];
    char auth[MAX_AUTH_LENGTH];
    int edition;
    int cost;
    int copies;
};

void addBook(struct Book books[], int *numBooks) {
    if (*numBooks >= MAX_BOOKS) {
        printf("Cannot add more books, the library is full.\n");
        return;
    }
    
    struct Book *book = &books[*numBooks];
    
    printf("Enter the title of the book: ");
    fgets(book->title, MAX_TITLE_LENGTH, stdin);
    book->title[strcspn(book->title, "\n")] = '\0';

    printf("Enter the author of the book: ");
    fgets(book->auth, MAX_AUTH_LENGTH, stdin);
    book->auth[strcspn(book->auth, "\n")] = '\0';

    printf("Enter the edition of the book: ");
    scanf("%d", &(book->edition));
    getchar();

    printf("Enter the cost of the book: ");
    scanf("%d", &(book->cost));
    getchar();

    printf("Enter the number of copies: ");
    scanf("%d", &(book->copies));
    getchar();

    (*numBooks)++;
}

void searchBook(struct Book books[], int numBooks, const char *searchTitle) {
    int found = 0;
    for (int i = 0; i < numBooks; i++) {
        if (strcmp(books[i].title, searchTitle) == 0) {
            printf("\nBook found!\n");
            printf("Title: %s\n", books[i].title);
            printf("Author: %s\n", books[i].auth);
            printf("Edition: %d\n", books[i].edition);
            printf("Cost: %d\n", books[i].cost);
            printf("Copies: %d\n", books[i].copies);
            found = 1;
            break;
        }
    }
    if (!found) {
        printf("Book not found!\n");
    }
}

void editBook(struct Book books[], int numBooks, const char *searchTitle) {
    int found = 0;
    for (int i = 0; i < numBooks; i++) {
        if (strcmp(books[i].title, searchTitle) == 0) {
            printf("Editing book:\n");

            printf("Enter new title: ");
            fgets(books[i].title, MAX_TITLE_LENGTH, stdin);
            books[i].title[strcspn(books[i].title, "\n")] = '\0';

            printf("Enter new author: ");
            fgets(books[i].auth, MAX_AUTH_LENGTH, stdin);
            books[i].auth[strcspn(books[i].auth, "\n")] = '\0';

            printf("Enter new edition: ");
            scanf("%d", &(books[i].edition));
            getchar();

            printf("Enter new cost: ");
            scanf("%d", &(books[i].cost));
            getchar();

            printf("Enter new number of copies: ");
            scanf("%d", &(books[i].copies));
            getchar();

            printf("Book updated successfully!\n");
            found = 1;
            break;
        }
    }
    if (!found) {
        printf("Book not found!\n");
    }
}

void deleteBook(struct Book books[], int *numBooks, const char *searchTitle) {
    int found = 0;
    for (int i = 0; i < *numBooks; i++) {
        if (strcmp(books[i].title, searchTitle) == 0) {
            for (int j = i; j < *numBooks - 1; j++) {
                books[j] = books[j + 1];
            }
            (*numBooks)--;
            printf("Book deleted successfully!\n");
            found = 1;
            break;
        }
    }
    if (!found) {
        printf("Book not found!\n");
    }
}

int main() {
    struct Book books[MAX_BOOKS];
    int numBooks = 0;
    int choice;
    char mainmenu;

    printf("WELCOME TO BOOKSTORE :)\n");
    printf("Enter Y for yes! \n");
    printf("Enter main menu?: ");
    scanf(" %c", &mainmenu);
    getchar();

    if (mainmenu == 'Y' || mainmenu == 'y') {
        while (1) {
            printf("1. Add \n2. Search \n3. Edit Book \n4. Delete Book \n5. End \n");
            printf("Option: ");
            scanf("%d", &choice);
            getchar();

            switch (choice) {
                case 1:
                    addBook(books, &numBooks);
                    printf("\nBook added successfully!\n");
                    break;
                case 2: {
                    char searchTitle[MAX_TITLE_LENGTH];
                    printf("Enter the title of the book to search for: ");
                    fgets(searchTitle, MAX_TITLE_LENGTH, stdin);
                    searchTitle[strcspn(searchTitle, "\n")] = '\0';
                    searchBook(books, numBooks, searchTitle);
                    break;
                }
                case 3: {
                    char searchTitle[MAX_TITLE_LENGTH];
                    printf("Enter the title of the book to edit: ");
                    fgets(searchTitle, MAX_TITLE_LENGTH, stdin);
                    searchTitle[strcspn(searchTitle, "\n")] = '\0';
                    editBook(books, numBooks, searchTitle);
                    break;
                }
                case 4: {
                    char searchTitle[MAX_TITLE_LENGTH];
                    printf("Enter the title of the book to delete: ");
                    fgets(searchTitle, MAX_TITLE_LENGTH, stdin);
                    searchTitle[strcspn(searchTitle, "\n")] = '\0';
                    deleteBook(books, &numBooks, searchTitle);
                    break;
                }
                case 5:
                    printf("Ending program.\n");
                    return 0;
                default:
                    printf("Error 404: Invalid input!\n");
                    break;
            }
        }
    } else {
        printf("Exiting program.\n");
    }

    return 0;
}
