Feature:
  Imagine you are building a social network. Starting from simple functionality. Users are now able to make posts and comment on them.
  You are working in the backend team that exposes the service: https://jsonplaceholder.typicode.com/ which has the following endpoints:
  1. Make posts: https://jsonplaceholder.typicode.com/posts
  2. Comment on posts: https://jsonplaceholder.typicode.com/comments
  3. List of users: https://jsonplaceholder.typicode.com/users
  Using Rest-Assured, Cucumber, and Java, create a few scenarios to test this functionality

#  Background: service is up and running

@DevEnvironment
  Scenario Outline: 1. Test that existing posts can be retreived with a GET request
    Given service is up and running
    When i search for "<id>" of a post with a GET method
    Then i should get the correct "<id>", "<title>" and "<body>" returned with status code of 200
    Examples:
      | id | title                       | body                                                                                                                                                                                              |
      | 4  | eum et est occaecati        | ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit |
      | 10 | optio molestias id quia eum | quo et expedita modi cum officia vel magni\ndoloribus qui repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error                                                              |

#  @TestToRun
  Scenario Outline: 2. Test that new posts can be created with the POST request
    Given service is up and running
    When I create a new post with the following details "<uId>","<title>" and "<body>",
    Then i should get the correct "<uId>","<title>" and "<body>" returned with status code of 201
    Examples:
      | uId   | title                        | body                        |
      | 10009 | this is my Test title        | this is my test body        |
      | 10027 | this is my second Test title | this is my second test body |

#  @TestToRun
  Scenario Outline: 3. Test that existing comments can be retreived with a GET request
    Given service is up and running
    When i search for comment with "<id>" with a GET method
    Then i the correct "<id>", "<name>", "<email>" and "<body>" are returned with status code of 200
    Examples:
      | id | name                                      | email                  | body                                                                                                                                                                        |
      | 2  | quo vero reiciendis velit similique earum | Jayne_Kuhic@sydney.com | est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et |

  @TestToRun
  Scenario Outline: 4. Test that new comments can be created with the POST request
    Given service is up and running
    When I create a new comment with the following details "<postId>","<name>", "<email>" and "<body>",
    Then i should get the correct "<postId>","<name>", "<email>" and "<body>", returned with status code of 201
    Examples:
      | postId | name                 | email        | body                 |
      | 10009  | this is my Test name | tesemail.com | this is my test body |



    #Task:
  # Scenario Outline: 5. Create the scenario for Test that existing Users can be retrieved with a GET request

  #  Scenario Outline: 6. Create scenario for Test that new Users  can be created with the POST request