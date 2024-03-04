import { UUID } from "crypto"

export type Product = {
    id: UUID;
    name: string;
    price: number;
    description: string;
    imageUri: string;
}