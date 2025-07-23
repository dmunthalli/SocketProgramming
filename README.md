### Instructions
- Open the project using intelliJ
- Run the Myserver main method
- Run the Client main method
### The bug
The bug was in the way I was reading the buffer.
```agsl
    while((line = reader.readLine()) != null){
        System.out.println(line);
    }
```
It was hanging here, it was somehow still waiting
for more data from the client.
The fix is to just include an end of message marker
on the client side (something like Bye :smile:)

### The fix
Include ```writer.println("_END_) ``` on the clint to indicate
end of message and use that on the server to check end of message.

```agsl
    PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
    writer.println("Hello how are you?");
    writer.println("Greetings from me");
    writer.println("_END_");
    writer.flush();
```
On the server
```agsl
    while((line = reader.readLine()) != null){
    if(line.equals("_END_")) break;
       System.out.println(line);
    }
```
