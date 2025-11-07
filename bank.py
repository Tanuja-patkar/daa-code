"""smart contract deposite withdraw
it is digital smart contract terms and condition sprcified
step1)remix id 
step2) contracts
step3) create new file--bank.sol

"deposite withdraw code"""
save as bank.sol (solidary sory file )

// SPDX-License-Identifier: MIT #lincencs line
pragma solidity ^0.8.0;  #solidary version
 
contract Bank {
    // Mapping customer addresses to their balances
    mapping(address => uint256) public balances;

    // Event for deposit
    event Deposit(address indexed user, uint256 amount);
    // Event for withdrawal
    event Withdrawal(address indexed user, uint256 amount);

    // Deposit Ether into the Bank
    function deposit() external payable {
        require(msg.value > 0, "Deposit amount must be greater than zero");
        balances[msg.sender] += msg.value; #ncreases the balance of the caller's address by the amount of Ether sent.
        emit Deposit(msg.sender, msg.value);
    }

    // Withdraw Ether from the Bank
    function withdraw(uint256 _amount) external {
        require(_amount > 0, "Withdrawal amount must be greater than zero");
        require(balances[msg.sender] >= _amount, "Insufficient balance");
        balances[msg.sender] -= _amount;
        // Safely transfer Ether to the user
        (bool success, ) = payable(msg.sender).call{value: _amount}("");
        require(success, "Withdrawal failed");
        emit Withdrawal(msg.sender, _amount);
    }

    // Check the balance of the caller
    function showBalance() external view returns (uint256) {
        return balances[msg.sender];
    }
}



#https://www.perplexity.ai/search/title-of-the-assignment-write-AIeu6LyHQrCq0PniTzganQ#17





#student data  code  
#StudentData.sol

// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentData {

    // Structure to hold student details
    struct Student {
        uint id;
        string name;
        uint age;
        uint marks;
    }

    // Dynamic array of students
    Student[] public students;

    // Owner of the contract
    address public owner;

    // Event to log fallback calls
    event FallbackCalled(address sender, uint value, bytes data);

    constructor() {
        owner = msg.sender;  // Set contract deployer as owner
    }

    // Function to add a new student to the array
    function addStudent(uint _id, string memory _name, uint _age, uint _marks) public {
        // For example, only owner can add students
        require(msg.sender == owner, "Only owner can add students");
        students.push(Student(_id, _name, _age, _marks));
    }

    // Get total number of students
    function getStudentCount() public view returns (uint) {
        return students.length;
    }

    // Get student details by index
    function getStudent(uint index) public view returns (uint, string memory, uint, uint) {
        require(index < students.length, "Invalid index");
        Student memory s = students[index];
        return (s.id, s.name, s.age, s.marks);
    }

    // Fallback function to capture calls with no matching function or direct ether send
    fallback() external payable {
        emit FallbackCalled(msg.sender, msg.value, msg.data);
    }

    // Function to get total balance of contract (with payable fallback)
    function getBalance() public view returns (uint) {
        return address(this).balance;
    }
}

