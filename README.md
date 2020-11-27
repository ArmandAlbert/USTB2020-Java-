# USTB2020-JAVA上机课部分代码


### 2020.11.27更新  
11月26日IDEA更新了，破解失效。下载新上传的安装包按教程破解即可。  

### 2020.11.20更新  
这里解释一下为什么中文会报错，看了一下CG的Java版本是7.x，而大家用的普遍是8/11/15，而且CG是tomcat搭建的服务器，因此对于中文的编码可能设置和本地编译器有出入（缺少正常显示中文的编码设置）。
所以采用的方法是使用java类中的BufferedWriter，新建一个BufferedWriter变量new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8))，使用此方法去输出字符串即可。
封装了一个输出类，直接调用print方法，传入String型参数即可输出。
```
class Printer {
    public static BufferedWriter stdout;

    static {
        stdout = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
    }

    public static void print(String str) throws IOException {
        stdout.write(str);
        stdout.flush();
    }
}
```
