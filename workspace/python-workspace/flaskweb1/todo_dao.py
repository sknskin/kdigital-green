import pymysql

class TodoDao:

    connection_info = { "host": "127.0.0.1", "user" : "pythonuser", "password" : "pythonuser", "database" : "pythondemo", "charset": "utf8" }

    def __init__(self):
        pass

    def insertTodo(self, todo):
        conn = pymysql.connect(**TodoDao.connection_info)
        cursor = conn.cursor()

        sql = """INSERT INTO todo (title, content) 
                 VALUES (%s, %s)"""

        cursor.execute(sql, todo)

        conn.commit()
        cursor.close()
        conn.close()

    def selectAllTodos(self):
        pass