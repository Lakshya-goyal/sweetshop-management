import React, { useEffect, useState } from "react";
import axios from "axios";

const API = "http://localhost:8080/api/sweets";

export default function App() {
  const [sweets, setSweets] = useState([]);
  const [form, setForm] = useState({ name: "", category: "", price: "", quantity: "" });
  const [purchase, setPurchase] = useState({ id: "", qty: "" });

  // NOTE: Backend currently has no GET ALL mapping.
  // If you add @GetMapping("/all") in backend, this will work.
  const fetchSweets = async () => {
    try {
      const res = await axios.get(API + "/all");
      setSweets(res.data);
    } catch (e) {
      console.error("Add GET ALL endpoint in backend");
    }
  };

  const addSweet = async () => {
    await axios.post(API, {
      name: form.name,
      category: form.category,
      price: Number(form.price),
      quantity: Number(form.quantity)
    });
    setForm({ name: "", category: "", price: "", quantity: "" });
    fetchSweets();
  };

  const purchaseSweet = async () => {
    await axios.get(API, {
      params: { id: purchase.id, qty: Number(purchase.qty) }
    });
    setPurchase({ id: "", qty: "" });
    fetchSweets();
  };

  useEffect(() => {
    fetchSweets();
  }, []);

  return (
    <div style={{ padding: 20, fontFamily: "Arial" }}>
      <h2>Sweet Shop Management</h2>

      <h3>Add Sweet</h3>
      <input placeholder="Name" value={form.name} onChange={e => setForm({ ...form, name: e.target.value })} />
      <input placeholder="Category" value={form.category} onChange={e => setForm({ ...form, category: e.target.value })} />
      <input placeholder="Price" value={form.price} onChange={e => setForm({ ...form, price: e.target.value })} />
      <input placeholder="Quantity" value={form.quantity} onChange={e => setForm({ ...form, quantity: e.target.value })} />
      <button onClick={addSweet}>Add</button>

      <h3>Purchase Sweet</h3>
      <input placeholder="Sweet ID" value={purchase.id} onChange={e => setPurchase({ ...purchase, id: e.target.value })} />
      <input placeholder="Quantity" value={purchase.qty} onChange={e => setPurchase({ ...purchase, qty: e.target.value })} />
      <button onClick={purchaseSweet}>Purchase</button>

      <h3>Available Sweets</h3>
      <ul>
        {sweets.map(s => (
          <li key={s.id}>{s.name} | {s.category} | ₹{s.price} | Qty: {s.quantity}</li>
        ))}
      </ul>
    </div>
  );
}