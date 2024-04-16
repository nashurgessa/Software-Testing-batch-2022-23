# Importing flask module in the project is mandatory
# An object of Flask class is our WSGI application.
from flask import Flask, jsonify, request
 
# Flask constructor takes the name of 
# current module (__name__) as argument.
app = Flask(__name__)
 
# The route() function of the Flask class is a decorator, 
# which tells the application which URL should call 
# the associated function.
@app.route('/')
# ‘/’ URL is bound with hello_world() function.
def hello_world():
    return 'Hello World'

users = {}
tasks = {}

@app.route('/add_todo', methods=["GET", "POST"])
def add_todo():
    return jsonify({
        "message": "Okay"
        });


@app.route('/register', methods=['POST'])
def register():
    # Safely get JSON data
    data = request.get_json()
    if not data:
        return jsonify({"error": "No data provided"}), 400

    try:
        # Retrieve data from JSON
        name = data['name']
        email = data['email']
        password = data['password']

        # Check for empty values
        if not all([name, email, password]):
            return jsonify({"error": "Missing name, email, or password"}), 400

        # Hash password using bcrypt
        # password_bytes = password.encode('utf-8')
        # hashed_password = bcrypt.hashpw(password_bytes, bcrypt.gensalt()).decode('utf-8')

        # Store in the dictionary (replace with database storage in production)
        users[email] = {'name': name, 'email': email, 'hashed_password': password}

        return jsonify({
            "name": name,
            "email": email
        }), 200
        
    except KeyError as e:
        # Handling missing form data
        return jsonify({"error": f"Missing field: {str(e)}"}), 400
        
    
 
# main driver function
if __name__ == '__main__':
 
    # run() method of Flask class runs the application 
    # on the local development server.
    app.run(host="0.0.0.0", port=8000, debug=True)