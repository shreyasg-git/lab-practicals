console.log("Hello there");

const inputEl = document.getElementById("term");
const keys = document.querySelectorAll(".oneKey");
const signKeys = document.querySelectorAll(".signKey");
const calculateButton = document.querySelector(".calculateBtn");
const ansEl = document.getElementById("ansDiv");
const backSpace = document.getElementById("backSpace");

keys.forEach((k) => {
  k.addEventListener("click", () => {
    term.value += k.id;
    console.log(parseInt(k.id));
  });
});

signKeys.forEach((sk) => {
  sk.addEventListener("click", () => {
    term.value += sk.id;
    console.log(sk.id);
  });
});

calculateButton.addEventListener("click", () => {
  // const regEx = /^\s*([-+]?)(\d+)(?:\s*([-+*\/])\s*((?:\s[-+])?\d+)\s*)+$/;
  const regEx2 = /^[\d\+\/\*\.\- \(\)]*$/;
  if (regEx2.test(term.value)) {
    setAnswerDiv(eval(term.value), "answer");
  } else {
    setAnswerDiv();
  }
});

backSpace.addEventListener("click", () => {
  const oldValue = term.value;
  console.log(term.value);
  term.value = oldValue.substring(0, oldValue.length - 1);
});

function setAnswerDiv(value, type) {
  if (type === "answer") {
    ansEl.style.color = "#00d111";
    ansEl.style.border = "2px solid #00d111";
    ansEl.innerHTML = value;
  } else {
    ansEl.innerHTML = "Invalid Input";
    ansEl.style.color = "#FF0000";
    ansEl.style.border = "2px solid #FF0000";
  }
}
