var foo = [1,2,3];
foo.push(5);
console.log(foo);
var bar = [4,5,6];
console.log(bar);

var baz = foo.concat(bar);
console.log(foo);
console.log(bar);
console.log(baz);

var shivanshu = {};
shivanshu.age = 23;
shivanshu.name = 'Shivanshu Goyal';
shivanshu.age = 11;

function hello() {
    return {
        age: 13,
        name: 'sjdhfk'
    };
};

foo = hello();
foo.age = 44;
foo.name;