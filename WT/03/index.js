console.log("Hello there");

// let username;
// username = window.prompt("Please Enter Your Name");

// console.log("Hey there", username);

// alert(`Hey there ${username}`);
// confirm("You sure bro");

const inputEl = document.getElementById("term");

const keys = document.querySelectorAll(".oneKey");
console.log(keys);
keys.forEach((k) => {
  k.addEventListener("click", () => {
    term.value += k.id;
    console.log(parseInt(k.id));
  });
});

const signKeys = document.querySelectorAll(".signKey");
signKeys.forEach((sk) => {
  sk.addEventListener("click", () => {
    term.value += sk.id;
    console.log(sk.id);
  });
});

const calculateButton = document.querySelector(".calculateBtn");
calculateButton.addEventListener("click", () => {
  console.log(eval(term.value));
});
